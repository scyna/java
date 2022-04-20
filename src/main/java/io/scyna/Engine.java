package io.scyna;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import com.datastax.driver.mapping.MappingManager;

import io.nats.client.Connection;
import io.nats.client.JetStream;
import io.nats.client.Nats;
import io.scyna.Generator.SerialNumber;
import io.scyna.proto.Configuration;
import io.scyna.proto.CreateSessionRequest;
import io.scyna.proto.CreateSessionResponse;

public class Engine {
    private static Engine instance;
    private final Connection connection;
    private final Session session;
    private final Generator id;
    private final Log logger;
    private String module;
    private final JetStream stream;
    private Settings settings;
    private final DB db;
    private final MappingManager mapping;

    private Engine(String module, long sessionID, Configuration config) throws IOException, InterruptedException {
        this.module = module;
        connection = Nats.connect(config.getNatsUrl());
        stream = connection.jetStream();
        id = new Generator();
        session = new Session(sessionID);
        logger = new Log(sessionID, true);
        /* Database: ScyllaDB */
        var hosts = config.getDBHost().split(",");
        db = DB.init(hosts, config.getDBUsername(), config.getDBPassword(), config.getDBLocation());
        settings = new Settings();
        mapping = new MappingManager(db.session());
    }

    public static void init(String managerURL, String module, String secret)
            throws URISyntaxException, IOException, InterruptedException {

        var req = CreateSessionRequest.newBuilder().setModule(module).setSecret(secret).build();
        var request = HttpRequest.newBuilder()
                .uri(new URI(managerURL + Path.SESSION_CREATE_URL))
                .POST(HttpRequest.BodyPublishers.ofByteArray(req.toByteArray()))
                .build();

        var response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofByteArray());
        if (response.statusCode() != 200) {
            throw new IOException();
        }
        var res = CreateSessionResponse.parseFrom(response.body());
        instance = new Engine(module, res.getSessionID(), res.getConfig());
        System.out.println("Engine Created for module:" + module);
        System.out.println(instance.id.next());

        /* registration */
        Signal.register(Path.SETTING_UPDATE_CHANNEL + module, new Settings.UpdateHandler());
    }

    public static Engine instance() {
        return instance;
    }

    public static SerialNumber initSerialNumber(String key) {
        return new SerialNumber(key);
    }

    public static Generator id() {
        return instance.id;
    }

    public static Session session() {
        return instance.session;
    }

    public static Log log() {
        return instance.logger;
    }

    public static String module() {
        return instance.module;
    }

    public static Connection connection() {
        return instance.connection;
    }

    public static JetStream stream() {
        return instance.stream;
    }

    public static Settings settings() {
        return instance.settings;
    }

    public static com.datastax.driver.core.Session db() {
        return instance.db.session();
    }

    public static MappingManager mapping() {
        return instance.mapping;
    }
}
