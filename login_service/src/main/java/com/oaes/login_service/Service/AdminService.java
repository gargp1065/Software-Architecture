package com.oaes.login_service.Service;

import com.oaes.login_service.Entity.Admin;
import com.oaes.login_service.Entity.Author;
import com.oaes.login_service.Repository.AdminRepo;
import com.oaes.login_service.Repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    @Autowired
    AuthorRepo authorRepo;

    public boolean registerAdmin(Admin admin) {
        adminRepo.save(admin);
        return true;
    }

    public boolean adminLogin(Admin admin) {
        Optional<Admin> obj = adminRepo.findAdminByUsername(admin.getUsername());
        if(obj.isEmpty())
        {
            return false;
        }
        if(obj.get().getPassword().equals(admin.getPassword()))
        {
            return true;
        }
        return false;
    }

    public boolean registerAuthor(Author author) {
        authorRepo.save(author);
        return true;
    }
}
