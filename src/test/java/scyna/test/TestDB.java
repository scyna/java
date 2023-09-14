package scyna.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import scyna.Engine;

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
    public void GivenGoodRequest_ShouldSuccess() throws InterruptedException {
        Thread.sleep(100);
    }
}
