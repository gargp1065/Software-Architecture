package com.oaes.instrument_service.Repository;

import com.oaes.instrument_service.Entity.MCQ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MCQRepository extends JpaRepository<MCQ, Integer>
{
    List<MCQ> findBySubject(String subject);
}
