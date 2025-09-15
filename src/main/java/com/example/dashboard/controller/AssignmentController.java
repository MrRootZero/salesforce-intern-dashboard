package com.example.dashboard.controller;

import com.example.dashboard.model.Assignment;
import com.example.dashboard.model.Submission;
import com.example.dashboard.repository.AssignmentRepository;
import com.example.dashboard.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentRepository assignmentRepository;
    private final SubmissionRepository submissionRepository;

    @Autowired
    public AssignmentController(AssignmentRepository assignmentRepository,
                                SubmissionRepository submissionRepository) {
        this.assignmentRepository = assignmentRepository;
        this.submissionRepository = submissionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> listAssignments() {
        List<Assignment> assignments = assignmentRepository.findAll();
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable Long id) {
        Optional<Assignment> assignment = assignmentRepository.findById(id);
        return assignment.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        Assignment saved = assignmentRepository.save(assignment);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id, @RequestBody Assignment updated) {
        return assignmentRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(updated.getTitle());
                    existing.setDescription(updated.getDescription());
                    existing.setDueAt(updated.getDueAt());
                    existing.setRubricJson(updated.getRubricJson());
                    Assignment saved = assignmentRepository.save(existing);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        return assignmentRepository.findById(id)
                .map(existing -> {
                    assignmentRepository.delete(existing);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<String> submitAssignment(@PathVariable Long id, @RequestBody Submission submission) {
        return assignmentRepository.findById(id)
                .map(assignment -> {
                    submission.setAssignment(assignment);
                    submissionRepository.save(submission);
                    return ResponseEntity.ok("Submission uploaded for assignment " + id);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
