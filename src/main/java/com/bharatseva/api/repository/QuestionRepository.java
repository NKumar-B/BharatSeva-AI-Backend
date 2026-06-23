package com.bharatseva.api.repository;

import com.bharatseva.api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // This method is used by your getUserQuestions endpoint
    List<Question> findByUserId(Long userId);
}