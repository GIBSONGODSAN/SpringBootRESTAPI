package com.gibson.gibson.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import com.gibson.gibson.domain.IndeedJobListing;

@Service
public class IndeedJobScraperService {

    @SuppressWarnings("null")
    public List<IndeedJobListing> scrapeJobs(String url) throws IOException {
        List<IndeedJobListing> jobListings = new ArrayList<>();
        
        try {
            Document doc = Jsoup.connect(url).get();

            Elements jobs = doc.select("li.css-5lfssm.eu4oa1w0"); // Adjust selector as needed

            for (Element job : jobs) {
                IndeedJobListing listing = new IndeedJobListing(url, url, url, url, url);

                // Handle potential exceptions during extraction
                try {
                    listing.setJobTitle(job.select("h2.jobTitle.css-14z7akl.eu4oa1w0 a").text());
                    listing.setCompany(job.select("span[data-testid='company-name']").text());
                    listing.setLocation(job.select("div[data-testid='text-location']").text());

                    Elements description = job.select("ul[style='list-style-type:circle;margin-top: 0px;margin-bottom: 0px;padding-left:20px;']");
                    if (!description.isEmpty()) {
                        listing.setDescription(description.first().text());
                    }

                    listing.setUrl(job.select("h2.jobTitle.css-14z7akl.eu4oa1w0 a").attr("href"));
                } catch (Exception e) {
                    // Log or handle parsing errors for specific elements
                    System.err.println("Error parsing job listing: " + e.getMessage());
                }

                jobListings.add(listing);
            }
        } catch (IOException e) {
            // Handle connectivity or general scraping errors
            System.err.println("Error scraping Indeed page: " + e.getMessage());
        }

        return jobListings;
    }
}
