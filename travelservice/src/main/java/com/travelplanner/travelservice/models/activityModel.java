package com.travelplanner.travelservice.models;

public class activityModel {
    private int activityId;
    private String activityHeader;
    private String activityText;
    private String imageUrl;

    // Default constructor
    public activityModel() {
    }

    // Constructor with parameters
    public activityModel(int activityId, String activityHeader, String activityText, String imageUrl) 
    {
        this.activityId = activityId;
        this.activityHeader = activityHeader;
        this.activityText = activityText;
        this.imageUrl = imageUrl;
    }

    // Getters and setters

    public int getActivityId() 
    {
        return activityId;
    }

    public void setActivityId(int activityId) 
    {
        this.activityId = activityId;
    }

    public String getActivityHeader() 
    {
        return activityHeader;
    }

    public void setActivityHeader(String activityHeader) 
    {
        this.activityHeader = activityHeader;
    }

    public String getActivityText() 
    {
        return activityText;
    }

    public void setActivityText(String activityText) 
    {
        this.activityText = activityText;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    // toString method for debugging
    @Override
    public String toString() 
    {
        return "Activity{" +
                "activityId=" + activityId +
                ", activityHeader='" + activityHeader + '\'' +
                ", activityText='" + activityText + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
