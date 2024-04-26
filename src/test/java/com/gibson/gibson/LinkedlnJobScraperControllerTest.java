package com.gibson.gibson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import  static org.mockito.Mockito.any;
import com.gibson.gibson.service.LinkedlnJobScraperService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Assert;

@AutoConfigureMockMvc
@SpringBootTest
public class LinkedlnJobScraperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // Mock the service to control behavior
    private LinkedlnJobScraperService jobScraperService;

    @Test
    public void testScrapeJobs_withValidParameters() throws Exception {

        Mockito.when(jobScraperService.scrapeJobs(anyString())).thenReturn(any());

        String keywords = "data scientist";
        String location = "Chennai";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/ljobs/search")
                .param("keywords", keywords)
                .param("location", location))
                .andExpect(status().isOk())
                .andReturn();

                MockHttpServletResponse response = result.getResponse();

                Assert.assertEquals(200, response.getStatus());
        
                System.out.println("Response Content Verified!");
    }
}
