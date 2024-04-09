package com.gibson.gibson.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.gibson.gibson.domain.LinkelnJobListing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class LinkedlnJobScraperService {

    public List<LinkelnJobListing> scrapeJobs(String url) throws IOException {
        List<LinkelnJobListing> jobListings = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();

        Elements li = doc.select("ul.jobs-search__results-list > li");

        for (Element item : li) {
            String jobTitle = item.select(".base-search-card__title").text();
            String hyperlink = item.select(".base-card__full-link").attr("href");

            jobListings.add(new LinkelnJobListing(jobTitle, hyperlink));
        }

        return jobListings;
    }
}
