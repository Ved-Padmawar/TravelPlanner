package com.travelplanner.travelservice.models;
import java.sql.*;
import java.util.*;
public class LoginSystem 
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) 
    {
        login();
    }

    public static void login() 
    {
        int attempts = 0;
        boolean accessGranted = false;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            while (attempts < 3) {
                String id = input("Enter ID: ");
                String password = input("Enter password: ");

                String query = "SELECT * FROM customer WHERE id = ? AND password = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, id);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) 
                {
                    System.out.println("Access granted");
                    accessGranted = true;
                    break;
                } 
                else 
                {
                    System.out.println("Invalid ID or password");
                    attempts++;
                }
            }

            if (!accessGranted) 
            {
                System.out.println("You have reached the login limit");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void signup() 
    {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) 
        {
            String newId = input("Enter a new ID: ");
            String newPassword = input("Enter a new password: ");
            String confirmPassword = input("Confirm password: ");

            if (newPassword.equals(confirmPassword)) 
            {
                String query = "INSERT INTO customer (id, password) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, newId);
                statement.setString(2, newPassword);
                statement.executeUpdate();

                System.out.println("Sign up successful!");
                login();
            } else {
                System.out.println("Passwords do not match. Please try again.");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static String input(String prompt) 
    {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        sc.close();
        return sc.nextLine();
    }
}
