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

    System.out.print("How many messages do you wish to enter? ");
    int totalMessagesToSend = scanner.nextInt();
    scanner.nextLine();
    }
   }
   
    boolean running = true;

    while (running) {
        System.out.println("\nPlease choose an option:");
        System.out.println("1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Quit");
        System.out.print("Enter your choice: ");

        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        
  
