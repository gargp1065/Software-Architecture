package com.oaes.instrument_service.Service;

import com.oaes.instrument_service.Entity.MCQ;
import com.oaes.instrument_service.Repository.AuthorRepository;
import com.oaes.instrument_service.Repository.MCQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MCQService {
    @Autowired
    MCQRepository mcqRepository;

    @Autowired
    AuthorRepository authorRepository;

    public boolean addMCQ(MCQ mcq, int authorId) {
        mcq.setAuthor(authorRepository.findById(authorId).get());
        mcqRepository.save(mcq);
        return true;
    }

    public List<MCQ> getItems(String subject, int count) {
        List<MCQ> items = mcqRepository.findBySubject(subject);
        List<MCQ> result = new ArrayList<MCQ>();
        for(MCQ mcq:items)
        {
            if(count==0)
            {
                break;
            }
            result.add(mcq);
        }
        return result;
    }
}
