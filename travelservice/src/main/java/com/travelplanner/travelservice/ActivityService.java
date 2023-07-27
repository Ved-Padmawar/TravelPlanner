package com.travelplanner.travelservice;

import java.util.Scanner;
import java.sql.*;
import org.json.*;


public class ActivityService {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/india_activities";
        String username = "root";
        String password = "7257";
        Scanner sc = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Take the state name input
            System.out.println("Enter State name:");
            String stateName= sc.nextLine();
             // Replace this with your input method

            // Query the database for activities of the given state
            JSONArray activitiesJson = getActivitiesForState(connection, stateName);

            // Print the JSON representation of activities
            System.out.println(activitiesJson.toString(4)); // Output with indentation

        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }

    private static JSONArray getActivitiesForState(Connection connection, String stateName) throws SQLException {
        String query = "SELECT activity_id, activity_text FROM activities WHERE state_name = ?";
        JSONArray activitiesJson = new JSONArray();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, stateName);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int activityId = resultSet.getInt("activity_id");
                String activityText = resultSet.getString("activity_text");

                // Create JSON object for each activity
                JSONObject activityJson = new JSONObject();
                activityJson.put("activity_id", activityId);
                activityJson.put("activity_text", activityText);

                // Add activity JSON object to the array
                activitiesJson.put(activityJson);
            }
        }

        return activitiesJson;
    }
}

    

