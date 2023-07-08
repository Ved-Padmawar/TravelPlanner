package com.travelplanner.travelservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import com.travelplanner.travelservice.models.*;

@RestController
public class Places {


	@GetMapping("/places")
	public String index() {
		return "list of places";
	}

    @GetMapping("/places/recommended")
	public String recommended() {

        List<RecommendedPlace> recommendedPlaces = new ArrayList<>();

        RecommendedPlace goa = new RecommendedPlace();
        goa.setName("Goa");
        goa.setLocation("West India");
        goa.setDescription("Goa is famous for its beautiful beaches, vibrant nightlife, and Portuguese architecture. It offers a unique blend of Indian and Western cultures.");
        goa.setImage("https://example.com/images/goa.jpg");
        goa.setRating(4.5);
        recommendedPlaces.add(goa);

        // Add more recommended places as needed

        Gson gson = new Gson();
        String jsonArray = gson.toJson(recommendedPlaces);
		return jsonArray;
	}
    
}
