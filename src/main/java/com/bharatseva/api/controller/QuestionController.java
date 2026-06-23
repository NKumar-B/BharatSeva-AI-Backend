package com.bharatseva.api.controller;

import com.bharatseva.api.model.Question; // USE YOUR ACTUAL MODEL
import com.bharatseva.api.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:5173")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    // 1. ENDPOINT: Persistent submission
    @PostMapping("/submit")
    public ResponseEntity<?> submitQuestion(@RequestBody Question ticket) {
        if (ticket.getStatus() == null) ticket.setStatus("UNANSWERED");
        if (ticket.getAnswerText() == null) ticket.setAnswerText("Awaiting review...");
        
        return ResponseEntity.ok(questionRepository.save(ticket));
    }

    // 2. ENDPOINT: Fetch by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Question>> getUserQuestions(@PathVariable Long userId) {
        return ResponseEntity.ok(questionRepository.findByUserId(userId));
    }

    // 3. ENDPOINT: Admin console view
    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionRepository.findAll());
    }

    // 4. ENDPOINT: Answer Question
    @PostMapping("/{id}/answer")
    public ResponseEntity<?> answerQuestion(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        Question q = questionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Question not found"));
            
        q.setAnswerText(payload.get("answer"));
        q.setStatus("ANSWERED");
        questionRepository.save(q);
        return ResponseEntity.ok().build();
    }

    
}