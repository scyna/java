package scyna.ex.customer.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import scyna.ex.customer.model.Error;
import scyna.ex.customer.model.Identity;

public class IdentityTest {
    @Test
    public void testCreateIdentity() {
        try {
            var identity = Identity.create("CMND", "123456789");
            assertEquals(identity.getType(), "CMND");
            assertEquals(identity.getNumber(), "123456789");
            assertEquals(identity.toString(), "CMND:123456789");
        } catch (scyna.Error e) {
            assertTrue(false);
        }
    }

    @Test
    public void testParseIdentity() {
        try {
            var identity = Identity.parse("CCCD:123456789");
            assertEquals(identity.getType(), "CCCD");
            assertEquals(identity.getNumber(), "123456789");
        } catch (scyna.Error e) {
            assertTrue(false);
        }
    }

    @Test
    public void testParseIdentityFail() {
        try {
            Identity.parse("CCCD_123456789");
        } catch (scyna.Error e) {
            assertEquals(e, Error.IDENTITY_INVALID);
        }
    }
}
