package scyna.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import scyna.Engine;
import scyna.Error;

public class TestDB {
    @BeforeClass
    public static void setup() throws Exception {
        Engine.Init("http://127.0.0.1:8081", "scyna_test", "123456");
    }

    @AfterClass
    public static void teardown() {
        Engine.Release();
    }

    @Test
    public void TestExecute() throws Error {
        Engine.DB().execute("INSERT INTO scyna_test.test_table(key, value) VALUES ('key1', 'value1')");
        Engine.DB().execute("INSERT INTO scyna_test.test_table(key, value) VALUES ('key2', 'value2')");
        Engine.DB().assureExists("SELECT * FROM scyna_test.test_table WHERE key = 'key1'");
        Engine.DB().assureNotExists("SELECT * FROM scyna_test.test_table WHERE key = 'key3'");
    }
}
