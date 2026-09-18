/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppoe;
import java.util.regex.Pattern;
/**
 *
 * @author student
 */
public class Login {
       // User details stored after successful registration
    private String storedFirstName;
    private String storedLastName;
    private String storedUsername;
    private String storedPassword;
    private boolean isLoggedIn;

    public Login() {
        // default constructor
    }

    // -------------------- Validation Methods --------------------
    //Checks if username has underscore and is max 5 characters
    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }
    //Checks password length,capital letter, number and special character
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasDigit && hasSpecial;
    }
    //Checks if cell number starts with +27 and has 9 digits
    public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) {
            return false;
        }
        // South African format: +27 followed by 9 digits
        // Reference: common SA mobile number validation patterns
        return Pattern.matches("^\\+27\\d{9}$", cellNumber);
    }

    // -------------------- Registration --------------------

    public String registerUser(String username, String password, String cellNumber,
                               String firstName, String lastName) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        // Store the details
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedFirstName = firstName;
        this.storedLastName = lastName;

        return """
              Username successfully captured.\n
              Password successfully captured.\n
              Cell phone number successfully added.
              """;
    }

    // -------------------- Login --------------------

    public boolean loginUser(String username, String password) {
        if (storedUsername == null || storedPassword == null) {
            isLoggedIn = false;
            return false;
        }

        isLoggedIn = storedUsername.equals(username) && storedPassword.equals(password);
        return isLoggedIn;
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + storedFirstName + ", " + storedLastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
