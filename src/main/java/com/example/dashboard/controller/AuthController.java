package com.example.dashboard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/callback")
    public ResponseEntity<String> handleCallback() {
        // TODO: handle OAuth callback
        return ResponseEntity.ok("Auth callback not yet implemented");
    }
}
