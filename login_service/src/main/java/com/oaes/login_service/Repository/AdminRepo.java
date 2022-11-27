package com.oaes.login_service.Repository;

import com.oaes.login_service.Entity.Admin;
import com.oaes.login_service.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Optional<Admin> findAdminByUsername(String username);
}
