package ex.registering.build;

import scyna.Engine;

public class Main {
    public static void main(String[] args) throws Exception {
        Engine.Init("http:/127.0.0.1:8081", "scyna_test", "123456");

        /* TODO: registration */

        Engine.Start();
    }
}
