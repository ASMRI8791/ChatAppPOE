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

}
