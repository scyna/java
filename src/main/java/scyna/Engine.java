package scyna;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import io.nats.client.Connection;
import io.nats.client.JetStream;
import io.nats.client.Nats;
import scyna.proto.Configuration;
import scyna.proto.CreateSessionRequest;
import scyna.proto.CreateSessionResponse;

public class Engine {
    private static Engine instance;
    private final Connection connection;
    private final Session session;
    private final Generator id;
    private final Logger logger;
    private String module;
    private final JetStream stream;
    private Settings settings;
    private final DB db;

    private Engine(String module, long sessionID, Configuration config) throws IOException, InterruptedException {
        this.module = module;
        id = new Generator();
        session = new Session(sessionID);
        logger = new Logger(sessionID, true);
        settings = new Settings();

        /* NATS */
        connection = Nats.connect(config.getNatsUrl()); // FIXME: hosts list and auth
        stream = connection.jetStream();
        System.out.println("Connected to NATS");

        /* ScyllaDB */
        var hosts = config.getDBHost().split(",");
        db = DB.Init(hosts, config.getDBUsername(), config.getDBPassword(), config.getDBLocation());
        settings = new Settings();
        System.out.println("Connected to ScyllaDB");
    }

    public static void Init(String managerURL, String module, String secret)
            throws java.lang.Exception {

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
        System.out.println("Engine created for module:" + module);

        /* setting */
        Signal.RegisterBySession(Path.SETTING_UPDATE_CHANNEL + module, new Settings.UpdateHandler());
        Signal.RegisterBySession(Path.SETTING_REMOVE_CHANNEL + module, new Settings.RemoveHandler());
    }

    public static Engine instance() {
        return instance;
    }

    public static Generator ID() {
        return instance.id;
    }

    public static DB DB() {
        return instance.db;
    }

    public static Logger LOG() {
        return instance.logger;
    }

    public static Session Session() {
        return instance.session;
    }

    public static String Module() {
        return instance.module;
    }

    public static Connection Connection() {
        return instance.connection;
    }

    public static JetStream Stream() {
        return instance.stream;
    }

    public static Settings Settings() {
        return instance.settings;
    }

    public static void Release() {
        DB().close();
        System.out.println("Engine Closed");
    }

    public static void Start() throws Exception {
        Event.startListening();
        System.out.println("Engine Started");
    }
}
