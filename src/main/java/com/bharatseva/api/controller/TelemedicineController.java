package com.bharatseva.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/api/telemedicine")
public class TelemedicineController {

    // Simplified to Map<String, String> to avoid array conversion issues
    private final Map<String, String> database = Map.of(
        "fever,cough", "Disease: Influenza | Medicine: Paracetamol, Vitamin C",
        "headache,fatigue", "Disease: Dehydration | Medicine: ORS, Electrolytes",
        "stomach_pain,nausea", "Disease: Gastritis | Medicine: Antacid, Domperidone"
    );

    @GetMapping("/diagnose")
    public ResponseEntity<String> getDiagnosis(@RequestParam String symptoms) {
        String result = database.getOrDefault(symptoms.toLowerCase(), "Consult a medical professional.");
        return ResponseEntity.ok(result);
    }
}