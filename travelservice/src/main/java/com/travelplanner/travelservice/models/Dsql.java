package com.travelplanner.travelservice.models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.*;

public class Dsql {



    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/india_activities";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Export states data to JSON
            exportStatesToJson(connection);

            // Export activities data to JSON
            exportActivitiesToJson(connection);

            // Export recommendations data to JSON
            exportRecommendationsToJson(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void exportStatesToJson(Connection connection) throws SQLException {
        String query = "SELECT JSON_ARRAYAGG(JSON_OBJECT('state_id', state_id, 'state_name', state_name)) AS states_json FROM states";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String statesJson = resultSet.getString("states_json");
                System.out.println("States JSON:\n" + statesJson);
            }
        }
    }

    private static void exportActivitiesToJson(Connection connection) throws SQLException {
        String query = "SELECT JSON_ARRAYAGG(JSON_OBJECT('activity_id', activity_id, 'activity_name', activity_name, 'state_id', state_id)) AS activities_json FROM activities";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String activitiesJson = resultSet.getString("activities_json");
                System.out.println("Activities JSON:\n" + activitiesJson);
            }
        }
    }

    private static void exportRecommendationsToJson(Connection connection) throws SQLException {
        String query = "SELECT JSON_ARRAYAGG(JSON_OBJECT('recommendation_id', recommendation_id, 'recommendation_text', recommendation_text, 'state_id', state_id)) AS recommendations_json FROM recommendations";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String recommendationsJson = resultSet.getString("recommendations_json");
                System.out.println("Recommendations JSON:\n" + recommendationsJson);
            }
        }
    }
    
}
