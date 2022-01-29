package com.mackenzie.ClientManagement.controllers;

import com.mackenzie.ClientManagement.dao.UserDao;
import com.mackenzie.ClientManagement.models.Usuario;
import com.mackenzie.ClientManagement.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDao dao;

    @Autowired
    private JWTUtil util;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody Usuario user) {

        Usuario loggedUser = dao.verifyUserAuth(user);

        if (loggedUser != null) {
            // Usando una variable redundante
            /*String token = util.create(String.valueOf(loggedUser.getId()), loggedUser.getEmail());
            return token;*/
            return util.create(String.valueOf(loggedUser.getId()), loggedUser.getEmail());
        }
        return "FAIL";
    }

}
