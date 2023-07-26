package com.travelplanner.travelservice;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.google.gson.Gson;
import com.travelplanner.travelservice.models.flightModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class FlightsController {

    @GetMapping("/flights")
    public String index() {
        return "list of flights";
    }
    @GetMapping("/flights/search")
    public String getSpecificFlightData(
            @RequestParam(value = "fromLoc", required = false) String fromLoc,
            @RequestParam(value = "toLoc", required = false) String toLoc,
            @RequestParam(value = "date_from", required = false) String date_from) {

        List<flightModel> flightDataList = new ArrayList<>();

        try {
            // Construct the API URL with the dynamic inputs
            String apiUrl = "https://api.tequila.kiwi.com/v2/search?fly_from=" + fromLoc
                    + "&fly_to=" + toLoc + "&date_from=" + date_from + "&date_to=" +
                    date_from +
                    "&max_stopovers=1&vehicle_type=aircraft&limit=10&curr=INR&sort=price";

            // Set the API key in the headers
            String apiKey = "1wU6jIQnCeBsJ12o94xH5xr0IpQ2YU_k";

            // Send a GET request to the API endpoint
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("apikey", apiKey);

            // Check if the request was successful (status code 200)
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder responseContent = new StringBuilder();
                String responseLine;
                while ((responseLine = responseReader.readLine()) != null) {
                    responseContent.append(responseLine);
                }
                responseReader.close();

                // Convert the API response JSON to flightModel objects
                JSONObject jsonObject = new JSONObject(responseContent.toString());
                // System.out.println(jsonObject.get("data"));
                JSONArray jsonArray = jsonObject.getJSONArray("data");

                // System.out.println(jsonArray.toString());

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject flightJson = jsonArray.getJSONObject(i);
                    // System.out.println(flightJson);
                    flightModel flight = new flightModel(
                            flightJson.getString("cityFrom"),
                            flightJson.getString("cityTo"),
                            flightJson.getJSONObject("price_dropdown").getDouble("base_fare"),
                            flightJson.getString("id"));
                    flightDataList.add(flight);
                }
                Gson gson = new Gson();
                String jsonArrayOutput = gson.toJson(flightDataList);
                return jsonArrayOutput;

            } else {
                System.out.println("Error occurred while fetching flight data. Response code: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
