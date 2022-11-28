package com.oaes.instrument_service.Controller;

import com.oaes.instrument_service.Entity.MCQ;
import com.oaes.instrument_service.Service.MCQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/instrument")
public class InstrumentController {

    @Autowired
    MCQService mcqService;

    @RequestMapping(method = RequestMethod.POST, value = "/add/MCQ/{authorId}")
    public boolean addItem(@RequestBody MCQ mcq, @PathVariable Integer authorId)
    {
        String optionA = mcq.getOptionA();
        String optionB = mcq.getOptionB();
        String optionC = mcq.getOptionC();
        String optionD = mcq.getOptionD();
        String correctAns = mcq.getCorrectAnswer();
        if( (optionA.compareTo(correctAns)) != 0 && (optionB.compareTo(correctAns)) != 0 && (optionC.compareTo(correctAns)) != 0 && (optionD.compareTo(correctAns)) != 0) {
            return false;
        }
        System.out.println(mcq);
        mcqService.addMCQ(mcq, authorId);
        return true;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get/{subject}/{count}")
    public List<MCQ> getSubject(@PathVariable String subject, @PathVariable Integer count) {
        return mcqService.getItems(subject, count);
    }
}
