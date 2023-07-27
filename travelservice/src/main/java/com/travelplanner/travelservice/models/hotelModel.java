package com.travelplanner.travelservice.models;

public class hotelModel 
{
    private String title;
    private String id;
    private double bubbleRating;
    private String priceForDisplay;

    public hotelModel(String title, String id, double bubbleRating, String priceForDisplay) 
    {
        this.title = title;
        this.id = id;
        this.bubbleRating = bubbleRating;
        this.priceForDisplay = priceForDisplay;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public double getBubbleRating() 
    {
        return bubbleRating;
    }

    public void setBubbleRating(double bubbleRating) 
    {
        this.bubbleRating = bubbleRating;
    }

    public String getPriceForDisplay() 
    {
        return priceForDisplay;
    }

    public void setPriceForDisplay(String priceForDisplay) 
    {
        this.priceForDisplay = priceForDisplay;
    }
}
