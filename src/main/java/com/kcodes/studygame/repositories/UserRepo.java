package com.kcodes.studygame.repositories;

import com.kcodes.studygame.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements CrudRepository<User> {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepo (SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User save(User newObj) {
        Session session = sessionFactory.getCurrentSession();
        session.save(newObj);
        return newObj;
    }

    @Override
    public boolean update(User updatedObj) {
        Session session = sessionFactory.getCurrentSession();
        User persistedUser = session.get(User.class, updatedObj.getId());
        persistedUser.setEmail(updatedObj.getEmail());
        persistedUser.setFirstName(updatedObj.getFirstName());
        persistedUser.setLastName(updatedObj.getLastName());
        persistedUser.setUsername(updatedObj.getUsername());
        persistedUser.setGameSet(updatedObj.getGameSet());
        session.update(persistedUser);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User deletedUser = session.get(User.class, id);
        session.delete(deletedUser);
        return false;
    }

}