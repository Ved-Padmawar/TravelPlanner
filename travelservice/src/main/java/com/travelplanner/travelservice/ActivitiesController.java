package com.travelplanner.travelservice;


import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActivitiesController {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/india_activities";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Export states data to JSON
            JSONArray statesJsonArray = exportStatesToJson(connection);

            // Export recommendations data to JSON
            JSONArray recommendationsJsonArray = exportRecommendationsToJson(connection);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static JSONArray exportStatesToJson(Connection connection) throws SQLException {
        String query = "SELECT state_id, state_name FROM states";
        JSONArray statesJsonArray = new JSONArray();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int stateId = resultSet.getInt("state_id");
                String stateName = resultSet.getString("state_name");

                JSONObject stateJson = new JSONObject();
                stateJson.put("state_id", stateId);
                stateJson.put("state_name", stateName);

                statesJsonArray.put(stateJson);
            }
        }

        return statesJsonArray;
    }

    private static JSONArray exportRecommendationsToJson(Connection connection) throws SQLException {
        String query = "SELECT recommendation_id, recommendation_text, state_id FROM recommendations";
        JSONArray recommendationsJsonArray = new JSONArray();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int recommendationId = resultSet.getInt("recommendation_id");
                String recommendationText = resultSet.getString("recommendation_text");
                int stateId = resultSet.getInt("state_id");

                JSONObject recommendationJson = new JSONObject();
                recommendationJson.put("recommendation_id", recommendationId);
                recommendationJson.put("recommendation_text", recommendationText);
                recommendationJson.put("state_id", stateId);

                recommendationsJsonArray.put(recommendationJson);
            }
        }

        return recommendationsJsonArray;
    }
}