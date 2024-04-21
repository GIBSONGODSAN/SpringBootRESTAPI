package com.gibson.gibson.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gibson.gibson.domain.IndeedJobListing;
import com.gibson.gibson.service.IndeedJobScraperService;

@RestController
@RequestMapping("/api/ijobs")
public class IndeedJobScraperController {

    @Autowired
    private IndeedJobScraperService jobScraperService;

    @GetMapping("/search")
    public List<IndeedJobListing> scrapeJobs(@RequestParam String keywords) throws IOException {
        System.out.println("Scraping jobs"+keywords);
        String url = buildUrl(keywords);
        System.out.println(url);
        return jobScraperService.scrapeJobs(url);
    }

    private String buildUrl(String keywords) {
        // Replace "in" with the appropriate Indeed subdomain for your target country (e.g., "uk" for United Kingdom)
        return "https://in.indeed.com/jobs?q=" + keywords;
    }
}
