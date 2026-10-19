/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapppoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */

public class MessageTest {
    
    
    // ========== Message Length Tests ==========

    @Test
    public void testMessageLength_Success() {
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertTrue(msg.getMessageText().length() <= 250);
    }
    
     @Test
    public void testMessageLength_Failure() {
        // Create a message longer than 250 characters
        String longMessage = "a".repeat(260);
        Message msg = new Message(1, "+27718693002", longMessage);
        assertTrue(msg.getMessageText().length() > 250);
    }
    
     // ========== Recipient Cell Number Tests ==========

    @Test
    public void testRecipientCell_Success() {
        Message msg = new Message(1, "+27718693002", "Hi Mike");
        String result = msg.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", result);
    }

    @Test
    public void testRecipientCell_Failure() {
        Message msg = new Message(1, "08575975889", "Hi Keegan");
        String result = msg.checkRecipientCell();
        assertTrue(result.contains("incorrectly formatted") || result.contains("international code"));
    }
    
     // ========== Message Hash Test ==========

    @Test
    public void testMessageHash_Correct() {
        Message msg = new Message(0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        String hash = msg.getMessageHash();

        // The hash should contain the first two digits of the ID, the message number, and the first + last word
        assertTrue(hash.contains(":"));
        assertTrue(hash.contains("HI"));
        assertTrue(hash.contains("TONIGHT") || hash.contains("TONIGHT?".toUpperCase().replace("?", "")));
        assertEquals(hash, hash.toUpperCase()); // Must be uppercase
    }



}
