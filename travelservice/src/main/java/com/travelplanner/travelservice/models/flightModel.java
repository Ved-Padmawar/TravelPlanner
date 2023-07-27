package com.travelplanner.travelservice.models;

public class flightModel {
    private String cityFrom;
    private String cityTo;
    private double baseFare;
    private String flightId;

    public flightModel(String cityFrom, String cityTo, double baseFare, String flightId) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.baseFare = baseFare;
        this.flightId = flightId;

    }

    public String getCityFrom() 
    {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) 
    {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() 
    {
        return cityTo;
    }

    public void setCityTo(String cityTo) 
    {
        this.cityTo = cityTo;
    }

    public double getBaseFare() 
    {
        return baseFare;
    }

    public void setBaseFare(double baseFare) 
    {
        this.baseFare = baseFare;
    }

     public String getFlightId() 
    {
        return flightId;
    }

    public void setFlightId(String flightId) 
    {
        this.flightId = flightId;
    }
}
