/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppoe;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Message class for PROG5121 Part 2 - Sending Messages
 */
public final class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    
   // Constructor
    public Message(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
       // Generate random 10-digit Message ID
    private String generateMessageID() {
        Random random = new Random();
        long id = 1000000000L + (long) (random.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }
      // checkMessageID()
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }
      // checkRecipientCell() using Pattern
    public String checkRecipientCell() {
        if (recipient == null || recipient.trim().isEmpty()) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }

        String cleaned = recipient.replaceAll("\\s+", "");

        // Must start with + followed by digits, maximum 12 characters
        Pattern pattern = Pattern.compile("^\\+\\d{1,11}$");

        if (pattern.matcher(cleaned).matches()) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
     // createMessageHash()
    public String createMessageHash() {
        String firstTwo = messageID.substring(0, 2);

        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        String hash = firstTwo + ":" + messageNumber + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    // SentMessage()
    public String SentMessage(int choice) {
        return switch (choice) {
            case 1 -> "Message successfully sent.";
            case 2 -> "Press 0 to delete the message.";
            case 3 -> "Message successfully stored.";
            default -> "Invalid option selected.";
        };
    }

    // printMessages()
    public String printMessages() {
        return "Message ID: " + messageID +
               "\nMessage Hash: " + messageHash +
               "\nRecipient: " + recipient +
               "\nMessage: " + messageText;
    }

    // returnTotalMessages()
    public int returnTotalMessages() {
        return messageNumber;
    }
      // Getters
    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public int getMessageNumber() {
        return messageNumber;
    }
}
    
    