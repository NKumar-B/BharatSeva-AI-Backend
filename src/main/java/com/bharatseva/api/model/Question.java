package com.bharatseva.api.model;

import jakarta.persistence.*;
import lombok.Data; // If you use Lombok; otherwise generate Getters/Setters manually

@Entity
@Table(name = "questions")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    private String userName;
    private String queryText;
    private String status;
    private String answerText;
}