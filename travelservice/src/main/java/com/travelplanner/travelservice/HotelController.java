package com.travelplanner.travelservice;

import com.google.gson.Gson;
import com.travelplanner.travelservice.models.hotelModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class HotelController {

    @GetMapping("/hotels")
    public String index() {
        return "list of hotels";
    }

    @GetMapping("/hotels/search")
    public String getSpecificHotelData(
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "checkIn", required = false) String checkIn,
            @RequestParam(value = "checkOut", required = false) String checkOut) {

        List<hotelModel> hotelDataList = new ArrayList<>();

        try {
            // Construct the API URL with the dynamic inputs
            String apiUrl = "https://tripadvisor16.p.rapidapi.com/api/v1/hotels/searchHotels?" +
                    "geoId=" + getGeoId(location) +
                    "&checkIn=" + checkIn +
                    "&checkOut=" + checkOut +
                    "&pageNumber=1&currencyCode=USD";

            // Set the API keys in the headers
            String rapidApiKey = "3ffa31065cmshdb0bf1e8e3afe8cp1bfa1fjsn0ee01bcde51e";
            String rapidApiHost = "tripadvisor16.p.rapidapi.com";

            // Send a GET request to the API endpoint
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-RapidAPI-Key", rapidApiKey);
            connection.setRequestProperty("X-RapidAPI-Host", rapidApiHost);

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

                // Convert the API response JSON to HotelModel objects
                JSONObject jsonObject = new JSONObject(responseContent.toString());
                JSONArray hotelArray = jsonObject.getJSONObject("data").getJSONArray("data");

                for (int i = 0; i < hotelArray.length(); i++) {
                    JSONObject hotelJson = hotelArray.getJSONObject(i);
                    hotelModel hotel = new hotelModel(
                            hotelJson.getString("title"),
                            hotelJson.getString("id"),
                            hotelJson.getJSONObject("bubbleRating").getDouble("rating"),
                            hotelJson.getString("priceForDisplay")
                    );
                    hotelDataList.add(hotel);
                }

                Gson gson = new Gson();
                String jsonArrayOutput = gson.toJson(hotelDataList);
                return jsonArrayOutput;

            } else {
                System.out.println("Error occurred while fetching hotel data. Response code: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Error";
    }

    // Helper method to get the geoId based on the location name
    private String getGeoId(String location) {
        try {
            String apiUrl = "https://tripadvisor16.p.rapidapi.com/api/v1/hotels/searchLocation?query=" + location;

            String rapidApiKey = "3ffa31065cmshdb0bf1e8e3afe8cp1bfa1fjsn0ee01bcde51e";
            String rapidApiHost = "tripadvisor16.p.rapidapi.com";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-RapidAPI-Key", rapidApiKey);
            connection.setRequestProperty("X-RapidAPI-Host", rapidApiHost);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder responseContent = new StringBuilder();
                String responseLine;
                while ((responseLine = responseReader.readLine()) != null) {
                    responseContent.append(responseLine);
                }
                responseReader.close();

                JSONObject jsonObject = new JSONObject(responseContent.toString());
                JSONArray locationArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < locationArray.length(); i++) {
                    JSONObject locationJson = locationArray.getJSONObject(i);
                    if (locationJson.has("secondaryText") && !locationJson.isNull("secondaryText")
                            && locationJson.has("geoId") && !locationJson.isNull("geoId")) {
                        String secondaryText = locationJson.getString("secondaryText");
                        if (secondaryText.contains("India")) {
                            return locationJson.getString("geoId").split(";")[1];
                        }
                    }
                }
            } else {
                System.out.println("Error occurred while fetching geoId. Response code: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}