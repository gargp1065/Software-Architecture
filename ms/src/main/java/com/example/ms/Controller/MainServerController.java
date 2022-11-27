package com.example.ms.Controller;

import com.example.ms.Entity.Admin;
import com.example.ms.Entity.Author;
import com.example.ms.Entity.MCQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/project")
public class MainServerController
{
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.POST, path = "/admin/register")
    public boolean registerAdmin(@RequestBody Admin admin) {
        boolean status = restTemplate.postForObject("http://login-service/user/admin/register", admin, Boolean.class);
        return status;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/admin/login")
    public boolean loginAdmin(@RequestBody Admin admin) {
        boolean status = restTemplate.postForObject("http://login-service/user/admin/login", admin, Boolean.class);
        return status;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/author/register")
    public boolean registerAuthor(@RequestBody Author author) {
        boolean status = restTemplate.postForObject("http://login-service/user/admin/author/register",author, Boolean.class);
        return status;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/author/login")
    public int loginAuthor(@RequestBody Author author) {
        int status = restTemplate.postForObject("http://login-service/user/author/login",author, Integer.class);
        return status;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add/MCQ/{authorId}")
    public boolean addItem(@RequestBody MCQ mcq, @PathVariable Integer authorId) {
        boolean status = restTemplate.postForObject("http://instrument-service/instrument/add/MCQ/"+Integer.toString(authorId),mcq, Boolean.class);
        return status;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/{subject}/{count}")
    public List<MCQ> getSubject(@PathVariable String subject, @PathVariable Integer count) {

        String url;
        url = "http://instrument-service/instrument/get/" + subject + "/" + String.valueOf(count);
        ResponseEntity<List<MCQ>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<MCQ>>() {});
        List<MCQ> mcqs = responseEntity.getBody();
        return mcqs.stream().collect(Collectors.toList());


    }
}
