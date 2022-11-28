package com.oaes.login_service.Controller;

import com.oaes.login_service.Entity.Admin;
import com.oaes.login_service.Entity.Author;
import com.oaes.login_service.Service.AdminService;
import com.oaes.login_service.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class LoginController
{
    @Autowired
    AuthorService authorService;

    @Autowired
    AdminService adminService;

    @RequestMapping(method = RequestMethod.POST, value = "/admin/login")
    public boolean loginAdmin(@RequestBody Admin admin) {
        return adminService.adminLogin(admin);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/register")
    public boolean registerAdmin(@RequestBody Admin admin) {
        String username = admin.getUsername();
        int usernameLength = username.length();
        String password = admin.getPassword();
        int passwordLength = password.length();
        System.out.println(password.isEmpty());
        System.out.println(passwordLength);
        // Test for login data validation{
        if(username.isEmpty() || usernameLength < 4 || usernameLength > 20 || password.isEmpty() || passwordLength < 8 || passwordLength > 20) {
            return false;
        }
        System.out.println("here");
        return adminService.registerAdmin(admin);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/author/register")
    public boolean registerAuthor(@RequestBody Author author) {
        return adminService.registerAuthor(author);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/author/login")
    public int loginAuthor(@RequestBody Author author) {
        return authorService.authorLogin(author);
    }
}
