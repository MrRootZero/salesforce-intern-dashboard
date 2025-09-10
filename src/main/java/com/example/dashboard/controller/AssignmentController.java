package com.example.dashboard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @GetMapping
    public ResponseEntity<String> listAssignments() {
        // TODO: return list of assignments
        return ResponseEntity.ok("List assignments endpoint");
    }

    @PostMapping
    public ResponseEntity<String> createAssignment() {
        // TODO: create assignment
        return ResponseEntity.ok("Create assignment endpoint");
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<String> submitAssignment(@PathVariable Long id) {
        // TODO: upload submission
        return ResponseEntity.ok("Submit assignment " + id);
    }
}
