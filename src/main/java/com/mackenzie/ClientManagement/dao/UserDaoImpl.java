package com.mackenzie.ClientManagement.dao;

import com.mackenzie.ClientManagement.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> list = manager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        if (list.isEmpty()) {
            return false;
        }
        String hashedPass = list.get(0).getPass();

        Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon.verify(hashedPass, user.getPass());
    }
}
