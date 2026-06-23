package com.bharatseva.api.repository;

import com.bharatseva.api.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    // Inherits standard data access methods automatically (.save(), .findAll(), etc.)
}