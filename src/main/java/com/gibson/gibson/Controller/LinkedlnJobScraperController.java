package com.gibson.gibson.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gibson.gibson.domain.LinkelnJobListing;
import com.gibson.gibson.service.LinkedlnJobScraperService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ljobs")
public class LinkedlnJobScraperController {

    @Autowired
    private LinkedlnJobScraperService jobScraperService;

    @GetMapping("/search")
    public List<LinkelnJobListing> scrapeJobs(@RequestParam String keywords, @RequestParam String location) throws IOException {
        String url = buildUrl(keywords, location);
        System.out.println("URL: " + url);
        return jobScraperService.scrapeJobs(url);
    }

    private String buildUrl(String keywords, String location) {
        return "https://www.linkedin.com/jobs/search/?keywords=" + keywords + "&location=" + location;
    }
}
