/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapppoe;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author student
 */
public class ChatAppPOE {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n".repeat(2));
            Login login = new Login();
            
            System.out.println("===== PROG5121 Part 1 - Registration & Login =====\n");
            
            // ========== REGISTRATION ==========
            System.out.println("--- Create Account ---");
            
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            
            System.out.print("Enter Username (must contain _ and max 5 characters): ");
            String username = scanner.nextLine();
            
            System.out.print("Enter Password (min 8 chars, capital, number, special): ");
            String password = scanner.nextLine();
            
            System.out.print("Enter Cell Phone Number (example: +27821234567): ");
            String cellNumber = scanner.nextLine();
            
            // Call the register method
            String registrationMessage = login.registerUser(username, password, cellNumber, firstName, lastName);
            System.out.println("\n" + registrationMessage);
            
            // ========== LOGIN ==========
            System.out.println("\n--- Login ---");
            
            System.out.print("Enter Username: ");
            String loginUsername = scanner.nextLine();
            
            System.out.print("Enter Password: ");
            String loginPassword = scanner.nextLine();
            
            // Call the returnLoginStatus method
            String loginMessage = login.returnLoginStatus(loginUsername, loginPassword);
            System.out.println("\n" + loginMessage);
            
           if (login.loginUser(loginUsername, loginPassword)) {
    System.out.println("You are now logged in!");
    System.out.println("Welcome to QuickChat.");

    
    ArrayList<Message> sentMessages = new ArrayList<>();
    ArrayList<Message> disregardedMessages = new ArrayList<>();
    ArrayList<Message> storedMessages = new ArrayList<>();
    ArrayList<String> messageHashes = new ArrayList<>();
    ArrayList<String> messageIDs = new ArrayList<>();
    
    //Load previously stored mesages from JSON
    storedMessages = Message.loadStoredMessages();

    System.out.print("How many messages do you wish to enter? ");
    int totalMessagesToSend = scanner.nextInt();
    scanner.nextLine();

    boolean running = true;

    while (running) {
        System.out.println("\nPlease choose an option:");
        System.out.println("1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Quit");
        System.out.println("4) Stored Messages");
        System.out.print("Enter your choice: ");

        int menuChoice = scanner.nextInt();
        scanner.nextLine();

        switch (menuChoice) {
            case 1:
                for (int i = 1; i <= totalMessagesToSend; i++) {
                    System.out.println("\n----- Message " + i + " of " + totalMessagesToSend + " -----");

                    System.out.print("Enter recipient cell number (e.g. +27718693002): ");
                    String recipient = scanner.nextLine();

                    System.out.print("Enter your message (max 250 characters): ");
                    String messageText = scanner.nextLine();

                    if (messageText.length() > 250) {
                        int over = messageText.length() - 250;
                        System.out.println("Message exceeds 250 characters by " + over + "; please reduce the size.");
                        i--;
                        continue;
                    }

                    Message msg = new Message(i, recipient, messageText);

                    String cellCheck = msg.checkRecipientCell();
                    System.out.println(cellCheck);

                    if (!cellCheck.contains("successfully")) {
                        i--;
                        continue;
                    }

                    System.out.println("\n----- Message Details -----");
                    System.out.println(msg.printMessages());
                    System.out.println("-----------------------------");

                    System.out.println("\nWhat would you like to do with this message?");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message to send later");
                    System.out.print("Enter your choice: ");

                    int action = scanner.nextInt();
                    scanner.nextLine();

                   String result = msg.SentMessage(action);
System.out.println(result);

if (action == 1) {
    //Send Message
    sentMessages.add(msg);
    messageHashes.add(msg.getMessageHash());
    messageIDs.add(msg.getMessageID());
} 
else if (action == 2) {
    // Disregard Message
    System.out.print("Enter 0 to confirm delete: ");
    int confirm = scanner.nextInt();
    scanner.nextLine();

    if (confirm == 0) {
        disregardedMessages.add(msg);
        System.out.println("Message deleted / disregarded.");
    } else {
        System.out.println("Message not deleted.");
    }
} 
else if (action == 3) {
    //Store Message
    storedMessages.add(msg);
    messageHashes.add(msg.getMessageHash());
    messageIDs.add(msg.getMessageID());
    Message.storeMessage(storedMessages);//Save to JSON
}
                }
                System.out.println("\nTotal number of messages processed: " + totalMessagesToSend);
                break;

            case 2:
                System.out.println("Coming Soon.");
                break;

            case 3:
                System.out.println("Total messages sent during this session: " + sentMessages.size());
                System.out.println("Thank you for using QuickChat. Goodbye!");
                running = false;
                break;
                
           case 4:
                    // ========== STORED MESSAGES MENU ==========
                    boolean storedMenu = true;

                    while (storedMenu) {
                        System.out.println("\n===== Stored Messages Menu =====");
                        System.out.println("a) Display sender and recipient of all stored messages");
                        System.out.println("b) Display the longest stored message");
                        System.out.println("c) Search for a message by Message ID");
                        System.out.println("d) Search for all messages by recipient");
                        System.out.println("e) Delete a message using Message Hash");
                        System.out.println("f) Display full report of all stored messages");
                        System.out.println("g) Back to main menu");
                        System.out.print("Enter your choice: ");

                        String choice = scanner.nextLine().toLowerCase();

                        switch (choice) {
                            case "a":
                                if (storedMessages.isEmpty()) {
                                    System.out.println("No stored messages found.");
                                } else {
                                    System.out.println("\n--- Sender and Recipient ---");
                                    for (Message m : storedMessages) {
                                        System.out.println("Recipient: " + m.getRecipient());
                                        System.out.println("Message: " + m.getMessageText());
                                        System.out.println("---------------------------");
                                    }
                                }
                                break;

                            case "b":
                                if (storedMessages.isEmpty()) {
                                    System.out.println("No stored messages found.");
                                } else {
                                    Message longest = storedMessages.get(0);
                                    for (Message m : storedMessages) {
                                        if (m.getMessageText().length() > longest.getMessageText().length()) {
                                            longest = m;
                                        }
                                    }
                                    System.out.println("\n--- Longest Stored Message ---");
                                    System.out.println(longest.printMessages());
                                }
                                break;

                            case "c":
                                System.out.print("Enter Message ID to search: ");
                                String searchID = scanner.nextLine();
                                boolean foundID = false;

                                for (Message m : storedMessages) {
                                    if (m.getMessageID().equals(searchID)) {
                                        System.out.println("\nMessage found:");
                                        System.out.println("Recipient: " + m.getRecipient());
                                        System.out.println("Message: " + m.getMessageText());
                                        foundID = true;
                                        break;
                                    }
                                }
                                if (!foundID) {
                                    System.out.println("No message found with that ID.");
                                }
                                break;

                            case "d":
                                System.out.print("Enter recipient number to search: ");
                                String searchRecipient = scanner.nextLine();
                                boolean foundRecipient = false;

                                System.out.println("\n--- Messages for " + searchRecipient + " ---");
                                for (Message m : storedMessages) {
                                    if (m.getRecipient().equals(searchRecipient)) {
                                        System.out.println(m.getMessageText());
                                        foundRecipient = true;
                                    }
                                }
                                if (!foundRecipient) {
                                    System.out.println("No messages found for that recipient.");
                                }
                                break;

                            case "e":
                                System.out.print("Enter Message Hash to delete: ");
                                String hashToDelete = scanner.nextLine();
                                boolean deleted = false;

                                for (int i = 0; i < storedMessages.size(); i++) {
                                    if (storedMessages.get(i).getMessageHash().equals(hashToDelete)) {
                                        System.out.println("Message: \"" + storedMessages.get(i).getMessageText() + "\" successfully deleted.");
                                        storedMessages.remove(i);
                                        Message.storeMessage(storedMessages);
                                        deleted = true;
                                        break;
                                    }
                                }
                                if (!deleted) {
                                    System.out.println("No message found with that hash.");
                                }
                                break;

                            case "f":
                                if (storedMessages.isEmpty()) {
                                    System.out.println("No stored messages to display.");
                                } else {
                                    System.out.println("\n========== FULL STORED MESSAGES REPORT ==========");
                                    for (Message m : storedMessages) {
                                        System.out.println(m.printMessages());
                                        System.out.println("-----------------------------------------------");
                                    }
                                }
                                break;

                            case "g":
                                storedMenu = false;
                                break;

                            default:
                                System.out.println("Invalid choice. Please select a–g.");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, 3 or 4.");
            }
        }

    } else {
        System.out.println("Login failed. Please try again.");
    }

    scanner.close();
}
    }
}
