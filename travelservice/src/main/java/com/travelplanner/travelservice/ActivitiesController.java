package com.travelplanner.travelservice;


import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActivitiesController {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/india_activities";
        String username = "root";
        String password = "7257";
        Scanner sc = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Take the state name input
            System.out.println("Enter State name:");
            String stateName = sc.nextLine();
             // Replace this with your input method

            // Query the database for activities of the given state
            JSONArray activitiesJson = getActivitiesForState(connection, stateName);

            // Print the JSON representation of activities
            System.out.println(activitiesJson.toString(4)); // Output with indentation

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static JSONArray getActivitiesForState(Connection connection, String stateName) throws SQLException {
        String query = "SELECT activity_id, activity_header, activity_text, image_url FROM activities WHERE state_name = ?";
        JSONArray activitiesJson = new JSONArray();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, stateName);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // int activityId = resultSet.getInt("activity_id");
                String activityHeader = resultSet.getString("activity_header");
                String activityText = resultSet.getString("activity_text");
                String imageURL = resultSet.getString("image_url");

                // Create JSON object for each activity
                JSONObject activityJson = new JSONObject();
                // activityJson.put("activity_id", activityId);
                activityJson.put("activity_header", activityHeader);
                activityJson.put("activity_text", activityText);
                activityJson.put("image_url", imageURL);

                // Add activity JSON object to the array
                activitiesJson.put(activityJson);
            }
        }

        return activitiesJson;
    }
}
}