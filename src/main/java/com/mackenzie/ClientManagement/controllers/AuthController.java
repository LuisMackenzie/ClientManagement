package com.mackenzie.ClientManagement.controllers;

import com.mackenzie.ClientManagement.dao.UserDao;
import com.mackenzie.ClientManagement.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDao dao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody Usuario user) {
        if (dao.verifyAuth(user)) {
            return "OK";
        }
        return "FAIL";
    }

}
