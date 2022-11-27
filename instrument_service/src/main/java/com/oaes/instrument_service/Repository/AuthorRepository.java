package com.oaes.instrument_service.Repository;

import com.oaes.instrument_service.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
