package com.example.showresultsapp;

// AnalyticsController.java
import com.example.showresultsapp.model.AnalyticsResult;
import com.example.showresultsapp.model.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AnalyticsController {

    private final String authenticationServiceUrl = "http://authentication-service:8080/authenticate";
    private final String analyticsServiceUrl = "http://mongo-db:8080/analytics";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/analytics")
    public ResponseEntity<Object> showAnalytics(@RequestParam String username, @RequestParam String password) {
        // Authenticate user using Authentication service
        ResponseEntity<String> authResponse = restTemplate.postForEntity(authenticationServiceUrl, new AuthenticationRequest(username, password), String.class);

        if (authResponse.getStatusCode().is2xxSuccessful() && "Authenticated".equals(authResponse.getBody())) {
            // Fetch analytics results from Analytics service
            ResponseEntity<AnalyticsResult> analyticsResponse = restTemplate.getForEntity(analyticsServiceUrl, AnalyticsResult.class);
            return ResponseEntity.ok(analyticsResponse.getBody());
        } else {
            // Handle authentication failure
            return ResponseEntity.status(401).body("Authentication failed.");
        }
    }
}
