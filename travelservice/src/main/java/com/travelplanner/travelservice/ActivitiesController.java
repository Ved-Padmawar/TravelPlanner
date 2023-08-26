package com.travelplanner.travelservice;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/activities")
public class ActivitiesController {

    private final String url = "jdbc:mysql://localhost:3306/india_activities";
    private final String username = "root";
    private final String password = "root";

    @GetMapping("/{stateName}")
    public String getActivitiesForState(@PathVariable String stateName) {

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            JSONArray activitiesJson = getActivitiesJsonForState(connection, stateName);

            return activitiesJson.toString(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Error";
    }

    private JSONArray getActivitiesJsonForState(Connection connection, String stateName) throws SQLException {
        String query = "SELECT activity_id, activity_header, activity_text, image_url FROM activities WHERE state_name = ?";
        JSONArray activitiesJson = new JSONArray();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, stateName);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String activityHeader = resultSet.getString("activity_header");
                String activityText = resultSet.getString("activity_text");
                String imageURL = resultSet.getString("image_url");

                JSONObject activityJson = new JSONObject();
                activityJson.put("activity_header", activityHeader);
                activityJson.put("activity_text", activityText);
                activityJson.put("image_url", imageURL);

                activitiesJson.put(activityJson);
            }
        }

        return activitiesJson;
    }
}
