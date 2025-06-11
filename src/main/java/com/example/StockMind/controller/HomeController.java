package com.example.StockMind.controller;

import com.example.StockMind.dto.ApiResponse;
import com.example.StockMind.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
public class HomeController {

    @Value("${twelvedata.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{symbol}")
    public ResponseEntity<ApiResponse<String>> Home(@PathVariable String symbol) {
        System.out.println("aaaa");
        String url = "https://api.twelvedata.com/time_series?symbol=" + symbol +
                "&interval=1min&outputsize=1&apikey=" + apiKey;
        try {
            String response = restTemplate.getForObject(url, String.class);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.ok(ResponseUtil.success("Data Accessed Successfully", "Hello World"));
    }
}
