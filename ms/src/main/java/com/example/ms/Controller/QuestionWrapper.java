package com.example.ms.Controller;

//import com.example.ms.Entity.MCQ;
import com.example.ms.Entity.Item;
import com.example.ms.Entity.MCQ;

import java.util.ArrayList;
import java.util.List;

public class QuestionWrapper {
    private List<MCQ> mcqs = new ArrayList<MCQ>();
    public QuestionWrapper()
    {

    }

    public List<MCQ> getMcqs() {
        return mcqs;
    }
}
