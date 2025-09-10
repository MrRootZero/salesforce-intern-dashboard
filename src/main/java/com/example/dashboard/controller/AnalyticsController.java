package com.example.dashboard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @GetMapping("/me")
    public ResponseEntity<String> getMyAnalytics() {
        // TODO: return analytics for current user
        return ResponseEntity.ok("My analytics endpoint");
    }

    @GetMapping("/manager/{id}")
    public ResponseEntity<String> getInternAnalytics() {
        // TODO: return analytics for specified intern
        return ResponseEntity.ok("Intern analytics endpoint");
    }
}
