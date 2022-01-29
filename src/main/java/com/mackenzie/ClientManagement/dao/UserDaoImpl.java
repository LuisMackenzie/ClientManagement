package com.mackenzie.ClientManagement.dao;

import com.mackenzie.ClientManagement.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    // Ojo aqui con este PRIVATE que puede se PUVBLIC
    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public List<Usuario> getUsers() {
        // Aqui conecta el model con la base de datos
        String query = "FROM Usuario";
        return manager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = manager.find(Usuario.class, id);
        manager.remove(usuario);
    }

    @Override
    public void registerUser(Usuario user) {
        manager.merge(user);
    }

    @Override
    public boolean verifyAuth(Usuario user) {
        String query = "FROM Usuario WHERE email = :email AND pass = :pass";
        List<Usuario> list = manager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("pass", user.getPass())
                .getResultList();

       /* if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }*/
        return !list.isEmpty();
    }
}
