package com.oaes.login_service.Repository;

import com.oaes.login_service.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
    Optional<Author> findAuthorByUsername(String username);
}
