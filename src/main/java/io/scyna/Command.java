package io.scyna;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import com.datastax.driver.core.exceptions.DriverException;
import com.datastax.driver.core.querybuilder.Batch;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.util.JsonFormat;

import io.nats.client.MessageHandler;
import io.scyna.proto.Request;

public class Command extends Endpoint {
    static final String TABLE_NAME = "event_store";
    static long version = 0;
    static String keyspace;

    public static void initSingleWriter(String keyspace) {
        var select = QueryBuilder.select(QueryBuilder.max("event_id")).from(keyspace, TABLE_NAME);
        try {
            var rs = Engine.DB().session().execute(select);
            var row = rs.one();

            long version = 1;
            if (row != null && (!row.isNull(0))) {
                version = row.getLong(0);
            }
            Command.version = version;
            Command.keyspace = keyspace;
        } catch (DriverException e) {
            Engine.LOG().error("Can not load SingleWriter configuration from database");
            System.exit(1);
        }
    }

    public static <T extends Message> void register(String url, Handler<T> handler) throws java.lang.Exception {
        System.out.println("Register Command:" + url);
        handler.init();
        var nc = Engine.connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(Utils.subscribeURL(url), "API");
    }

    public static abstract class Handler<T extends Message> extends BaseHandler implements MessageHandler {
        protected T request;
        protected Parser<T> parser;
        protected Message.Builder builder;
        protected Batch batch;

        protected abstract void execute() throws io.scyna.Error;

        public void init() throws java.lang.Exception {
            try {
                Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
                Method m = cls.getMethod("newBuilder");
                builder = (Message.Builder) m.invoke(null);
                var tObj = builder.build();
                parser = (Parser<T>) tObj.getParserForType();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                throw new java.lang.Exception();
            }
        }

        @Override
        public void onMessage(io.nats.client.Message msg) {
            try {
                var request = Request.parseFrom(msg.getData());
                context.id = request.getTraceID();
                reply = msg.getReplyTo();
                JSON = request.getJSON();
                flushed = false;
                var requestBody = request.getBody();
                source = request.getData();
                if (JSON) {
                    builder.clear();
                    JsonFormat.parser().merge(requestBody.toStringUtf8(), builder);
                    this.request = (T) builder.build();
                    builder.clear();
                } else {
                    this.request = parser.parseFrom(requestBody);
                }

                batch = QueryBuilder.batch();// new batch for new request

                this.execute();
                if (!flushed) {
                    flush(200, io.scyna.Error.OK.toProto());
                }
            } catch (io.scyna.Error e) {
                context.error(e.getMessage());
                flush(400, e.toProto());
            } catch (InvalidProtocolBufferException e) {
                flush(400, io.scyna.Error.BAD_REQUEST.toProto());
            }
        }

        protected void storeEvent(long entity, String channel, Message event) throws io.scyna.Error {
            if (version == 0) {
                context.error("SingleWriter is not initialized");
                System.exit(1);
            }

            try {
                var id = version + 1;
                var data = event.toByteArray();
                batch.add(QueryBuilder.insertInto(keyspace, TABLE_NAME)
                        .value("event_id", id)
                        .value("entity_id", entity)
                        .value("channel", channel)
                        .value("data", data));

                Engine.DB().session().execute(batch);
                version = id;
                context.publishEvent(channel, data);
            } catch (DriverException e) {
                e.printStackTrace();
                throw io.scyna.Error.SERVER_ERROR;
            }
        }
    }
}
