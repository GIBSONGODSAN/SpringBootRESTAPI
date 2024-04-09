package com.gibson.gibson.domain;

public class IndeedJobListing {
    private String jobTitle;
    private String company;
    private String location;
    private String description;
    private String url;

    public IndeedJobListing(String jobTitle, String company, String location, String description, String url) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.location = location;
        this.description = description;
        this.url = url;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    

}
