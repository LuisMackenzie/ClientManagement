package com.mackenzie.ClientManagement.controllers;

import com.mackenzie.ClientManagement.dao.UserDao;
import com.mackenzie.ClientManagement.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UserDao dao;

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable long id) {
        Usuario user = new Usuario();
        user.setId(id);
        user.setName("Lucas");
        user.setLast("Moy");
        user.setEmail("lucas@gmail.com");
        user.setPhone("600969696");
        user.setPass("1234");
        return user;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<Usuario> getAllUsers() {
        return dao.getUsers();
    }

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody Usuario user) {
        dao.registerUser(user);
    }

    @RequestMapping(value = "api/edit")
    public Usuario editUsuario() {
        Usuario user = new Usuario();
        user.setName("Lucas");
        user.setLast("Moy");
        user.setEmail("lucas@gmail.com");
        user.setPhone("600969696");
        user.setPass("1234");
        return user;
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable Long id) {
        dao.delete(id);

    }

    @RequestMapping(value = "api/search")
    public Usuario searchUsuario() {
        Usuario user = new Usuario();
        user.setName("Lucas");
        user.setLast("Moy");
        user.setEmail("lucas@gmail.com");
        user.setPhone("600969696");
        user.setPass("1234");
        return user;
    }
}
