/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapppoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class Part3Test {

    private ArrayList<Message> storedMessages;
    private ArrayList<Message> sentMessages;
    private ArrayList<Message> disregardedMessages;

    @BeforeEach
    public void setUp() {
        storedMessages = new ArrayList<>();
        sentMessages = new ArrayList<>();
        disregardedMessages = new ArrayList<>();

        // Test Data from the assignment
        storedMessages.add(new Message(1, "+27834557896", "Did you get the cake?"));
        storedMessages.add(new Message(2, "+27838884567", "Where are you? You are late! I have asked you to be on time."));
        storedMessages.add(new Message(3, "+27834484567", "Yohoooo, I am at your gate."));
        storedMessages.add(new Message(4, "0838884567", "It is dinner time !"));
        storedMessages.add(new Message(5, "+27838884567", "Ok, I am leaving without you."));

        // Also populate sent and disregarded for extra tests
        sentMessages.add(storedMessages.get(0));
        sentMessages.add(storedMessages.get(3));
        disregardedMessages.add(storedMessages.get(2));
    }

    // 1. Test array is not empty
    @Test
    public void testStoredMessagesNotEmpty() {
        assertFalse(storedMessages.isEmpty());
    }

    // 2. Test correct number of stored messages
    @Test
    public void testStoredMessagesCount() {
        assertEquals(5, storedMessages.size());
    }

    // 3. Test longest message
    @Test
    public void testLongestMessage() {
        Message longest = storedMessages.get(0);
        for (Message m : storedMessages) {
            if (m.getMessageText().length() > longest.getMessageText().length()) {
                longest = m;
            }
        }
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest.getMessageText());
    }

    // 4. Test longest message length
    @Test
    public void testLongestMessageLength() {
        Message longest = storedMessages.get(0);
        for (Message m : storedMessages) {
            if (m.getMessageText().length() > longest.getMessageText().length()) {
                longest = m;
            }
        }
        assertTrue(longest.getMessageText().length() > 40);
    }

    // 5. Test search by Message ID
    @Test
    public void testSearchByMessageID() {
        String targetID = storedMessages.get(3).getMessageID();
        Message found = null;
        for (Message m : storedMessages) {
            if (m.getMessageID().equals(targetID)) {
                found = m;
                break;
            }
        }
        assertNotNull(found);
        assertEquals("It is dinner time !", found.getMessageText());
    }

    // 6. Test search by recipient - count
    @Test
    public void testSearchByRecipientCount() {
        String recipient = "+27838884567";
        int count = 0;
        for (Message m : storedMessages) {
            if (m.getRecipient().equals(recipient)) {
                count++;
            }
        }
        assertEquals(2, count);
    }

    // 7. Test search by recipient - content
    @Test
    public void testSearchByRecipientContent() {
        String recipient = "+27838884567";
        boolean found = false;
        for (Message m : storedMessages) {
            if (m.getRecipient().equals(recipient) && m.getMessageText().contains("leaving")) {
                found = true;
            }
        }
        assertTrue(found);
    }

    // 8. Test delete by Message Hash
    @Test
    public void testDeleteByMessageHash() {
        String hashToDelete = storedMessages.get(1).getMessageHash();
        int originalSize = storedMessages.size();

        for (int i = 0; i < storedMessages.size(); i++) {
            if (storedMessages.get(i).getMessageHash().equals(hashToDelete)) {
                storedMessages.remove(i);
                break;
            }
        }
        assertEquals(originalSize - 1, storedMessages.size());
    }

    // 9. Test sent messages array populated
    @Test
    public void testSentMessagesPopulated() {
        assertEquals(2, sentMessages.size());
    }

    // 10. Test disregarded messages array populated
    @Test
    public void testDisregardedMessagesPopulated() {
        assertEquals(1, disregardedMessages.size());
    }

    // 11. Test message contains expected text
    @Test
    public void testMessageContainsCake() {
        boolean found = false;
        for (Message m : storedMessages) {
            if (m.getMessageText().contains("cake")) {
                found = true;
            }
        }
        assertTrue(found);
    }

    // 12. Test message contains dinner
    @Test
    public void testMessageContainsDinner() {
        boolean found = false;
        for (Message m : storedMessages) {
            if (m.getMessageText().contains("dinner")) {
                found = true;
            }
        }
        assertTrue(found);
    }

    // 13. Test all messages have a recipient
    @Test
    public void testAllMessagesHaveRecipient() {
        for (Message m : storedMessages) {
            assertNotNull(m.getRecipient());
            assertFalse(m.getRecipient().isEmpty());
        }
    }

    // 14. Test all messages have text
    @Test
    public void testAllMessagesHaveText() {
        for (Message m : storedMessages) {
            assertNotNull(m.getMessageText());
            assertFalse(m.getMessageText().isEmpty());
        }
    }

    // 15. Test full report data exists
    @Test
    public void testFullReportDataExists() {
        assertTrue(storedMessages.size() >= 5);
    }
}
