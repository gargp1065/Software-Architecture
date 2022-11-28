package com.oaes.instrument_service;

import com.oaes.instrument_service.Entity.MCQ;
import com.oaes.instrument_service.Service.ItemService;
import com.oaes.instrument_service.Service.MCQService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class InstrumentServiceApplicationTests {

    @Autowired
    ItemService itemService;

    @Autowired
    MCQService mcqService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void contextLoads() {
    }

    //Predicate 2 for testing the instrument controller
    // line number 20 in instrumentController

    // Predicate is if(optionA != correctAns && optionB != correctAns && optionC != correctAns && optionD != correctAns)
    // clauses are
    /*
        a: optionA != correctAns
        b: optionB != correctAns
        c: optionC != correctAns
        d: optionD != correctAns
     */

    //Test Case 1: a is major clause
    // Predicate is true, when a is true

    @Test
    public void checkOptionValue1() throws Exception {
        MCQ mcq = new MCQ(5, "fruit", "brinjal", "GK", null, "apple", "mango", "banana", "orange");
        mockMvc.perform(MockMvcRequestBuilders.post("/instrument/add/MCQ/2").contentType("application/json")
                .content(objectMapper.writeValueAsString(mcq))).andExpect(content().string("false"));
    }

    //Test Case 2: a is major clause
    // Predicate is false, when a is false

    @Test
    public void checkOptionValue2() throws Exception {
        MCQ mcq = new MCQ(5, "fruit", "banana", "GK", null, "banana", "circle", "apple", "blood");
        mockMvc.perform(MockMvcRequestBuilders.post("/instrument/add/MCQ/2").contentType("application/json")
                .content(objectMapper.writeValueAsString(mcq))).andExpect(content().string("true"));
    }

    //Test Case 3: b is major clause
    // Predicate is true, when b is true

    @Test
    public void checkOptionValue3() throws Exception {
        MCQ mcq = new MCQ(5, "fruit", "banana", "GK", null, "brinjal", "circle", "apple", "blood");
        mockMvc.perform(MockMvcRequestBuilders.post("/instrument/add/MCQ/2").contentType("application/json")
                .content(objectMapper.writeValueAsString(mcq))).andExpect(content().string("false"));
    }

    //Test Case 4: b is major clause
    // Predicate is false, when b is false

    @Test
    public void checkOptionValue4() throws Exception {
        MCQ mcq = new MCQ(5, "fruit", "mango", "GK", null, "apple", "mango", "banana", "orange");
        mockMvc.perform(MockMvcRequestBuilders.post("/instrument/add/MCQ/2").contentType("application/json")
                .content(objectMapper.writeValueAsString(mcq))).andExpect(content().string("true"));
    }

    //Test Case 5: c is major clause
    // Predicate is true, when c is true
    @Test
    public void checkOptionValue5() throws Exception {
        MCQ mcq = new MCQ(5, "fruit", "brinjal", "GK", null, "apple", "mango", "banana", "orange");
        mockMvc.perform(MockMvcRequestBuilders.post("/instrument/add/MCQ/2").contentType("application/json")
                .content(objectMapper.writeValueAsString(mcq))).andExpect(content().string("false"));
    }

    //Test Case 6: c is major clause
    // Predicate is false, when c is false
    @Test
    public void checkOptionValue6() throws Exception {
        MCQ mcq = new MCQ(5, "fruit", "banana", "GK", null, "apple", "mango", "banana", "orange");
        mockMvc.perform(MockMvcRequestBuilders.post("/instrument/add/MCQ/2").contentType("application/json")
                .content(objectMapper.writeValueAsString(mcq))).andExpect(content().string("true"));
    }

    //Test Case 7: d is major clause
    // Predicate is true, when d is true
    @Test
    public void checkOptionValue7() throws Exception {
        MCQ mcq = new MCQ(5, "fruit", "brinjal", "GK", null, "apple", "mango", "banana", "orange");
        mockMvc.perform(MockMvcRequestBuilders.post("/instrument/add/MCQ/2").contentType("application/json")
                .content(objectMapper.writeValueAsString(mcq))).andExpect(content().string("false"));
    }

    //Test Case 8: d is major clause
    // Predicate is false, when d is false
    @Test
    public void checkOptionValue8() throws Exception {
        MCQ mcq = new MCQ(5, "fruit", "orange", "GK", null, "apple", "mango", "banana", "orange");
        mockMvc.perform(MockMvcRequestBuilders.post("/instrument/add/MCQ/2").contentType("application/json")
                .content(objectMapper.writeValueAsString(mcq))).andExpect(content().string("true"));
    }


}
