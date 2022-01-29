package com.mackenzie.ClientManagement.dao;

import com.mackenzie.ClientManagement.models.Usuario;

import java.util.List;

public interface UserDao {

    public abstract List<Usuario> getUsers();

    public abstract void delete(Long id);

    public abstract void registerUser(Usuario user);

    public abstract boolean verifyAuth(Usuario user);
}
