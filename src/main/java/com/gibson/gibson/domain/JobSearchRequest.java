package com.gibson.gibson.domain;

public class JobSearchRequest {

    private String keywords;
    private String location;
  
    // Getters and Setters
    public String getKeywords() {
      return keywords;
    }
  
    public void setKeywords(String keywords) {
      this.keywords = keywords;
    }
  
    public String getLocation() {
      return location;
    }
  
    public void setLocation(String location) {
      this.location = location;
    }
  
    // Optional: Constructor (if needed)
    public JobSearchRequest(String keywords, String location) {
      this.keywords = keywords;
      this.location = location;
    }
  }
  