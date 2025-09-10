package com.example.dashboard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {

    @GetMapping
    public ResponseEntity<String> listBadges() {
        // TODO: return list of badges
        return ResponseEntity.ok("List badges endpoint");
    }
}
