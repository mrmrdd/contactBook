package com.ak.repository;

import com.ak.entity.Contact;
import com.ak.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MacDuck on 11/2/16.
 */
@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void save(User user){
        getSession().save(user);
    }

    public User getByName(String name) {
        return (User) getSession().load(User.class, name);
    }

    public void udpate(User user){
        getSession().update(user);
    }
}
