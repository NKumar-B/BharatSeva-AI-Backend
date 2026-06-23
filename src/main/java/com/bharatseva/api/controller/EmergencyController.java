package com.bharatseva.api.controller;

import com.bharatseva.api.model.EmergencyAlert;
import com.bharatseva.api.repository.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/emergency")
@CrossOrigin(origins = "http://localhost:5173")
public class EmergencyController {

    @Autowired
    private EmergencyRepository emergencyRepository;

    @PostMapping("/trigger")
    public ResponseEntity<EmergencyAlert> triggerSOS(@RequestBody EmergencyAlert alert) {
        alert.setTimestamp(LocalDateTime.now());
        EmergencyAlert savedAlert = emergencyRepository.save(alert);
        return ResponseEntity.ok(savedAlert);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmergencyAlert>> getAllAlerts() {
        return ResponseEntity.ok(emergencyRepository.findAll());
    }
}