package com.jeonguk.bcript;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.Assert.assertTrue;

public class BcriptTest {
    @Test
    public void bcriptMatchedTest() {
        final String  originalPassword = "password";
        final String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
        assertTrue(matched);
    }
}
