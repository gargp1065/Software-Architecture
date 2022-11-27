package com.oaes.login_service.Service;

import com.oaes.login_service.Entity.Author;
import com.oaes.login_service.Repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;

    public int authorLogin(Author author) {
        Optional<Author> obj = authorRepo.findAuthorByUsername(author.getUsername());
        if(obj.isEmpty())
        {
            return -1;
        }
        if(obj.get().getPassword().equals(author.getPassword()))
        {
            return obj.get().getAuthorId();
        }
        return -1;
    }
}
