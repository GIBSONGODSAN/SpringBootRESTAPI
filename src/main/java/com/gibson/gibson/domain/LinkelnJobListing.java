package com.gibson.gibson.domain;

public class LinkelnJobListing {
    private String jobTitle;
    private String hyperlink;

    public LinkelnJobListing(String jobTitle, String hyperlink) {
        this.jobTitle = jobTitle;
        this.hyperlink = hyperlink;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

}
