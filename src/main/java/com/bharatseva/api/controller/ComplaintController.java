package com.bharatseva.api.controller;

import com.bharatseva.api.model.Complaint;
import com.bharatseva.api.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Enables cross-origin connections to your frontend dev server
@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    // Endpoint to securely record citizen reported grievances[cite: 1]
    @PostMapping("/submit")
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        Complaint savedComplaint = complaintRepository.save(complaint);
        return new ResponseEntity<>(savedComplaint, HttpStatus.CREATED);
    }

    // Endpoint to track filed reports on the frontend dashboard view[cite: 1]
    @GetMapping("/all")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(complaintRepository.findAll());
    }

    // Endpoint for Gov Employees to update the live status of a grievance
    @PutMapping("/{id}/status")
    public ResponseEntity<Complaint> updateComplaintStatus(
            @PathVariable Long id, 
            @RequestParam String newStatus) {
        
        return complaintRepository.findById(id).map(complaint -> {
            complaint.setStatus(newStatus);
            Complaint updated = complaintRepository.save(complaint);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
}