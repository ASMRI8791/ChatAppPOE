/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapppoe;
import java.util.Scanner;
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
            
            if (login.loginUser(loginUsername, loginPassword)){
            System.out.println("You are now logged in!");
            }else{
                System.out.println("Login failed Please try again");
            System.out.println("\nThank you for using the Chat App!");
            scanner.close();
        }
        }
    }
   }
  
