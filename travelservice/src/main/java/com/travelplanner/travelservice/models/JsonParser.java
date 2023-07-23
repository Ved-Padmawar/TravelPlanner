package com.travelplanner.travelservice.models;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<Double> parseBaseFares(String filePath) throws Exception {
        JSONTokener tokener = new JSONTokener(new FileReader(filePath));
        JSONObject jsonData = new JSONObject(tokener);
        JSONArray dataArray = jsonData.getJSONArray("data");

        List<Double> baseFares = new ArrayList<>();
        // Add the base fares of the first five flights to the list
        for (int i = 0; i < 5 && i < dataArray.length(); i++) {
            JSONObject flight = dataArray.getJSONObject(i);
            JSONObject priceDropdown = flight.getJSONObject("price_dropdown");
            double baseFare = priceDropdown.getDouble("base_fare");
            baseFares.add(baseFare);
        }

        return baseFares;
    }
}
