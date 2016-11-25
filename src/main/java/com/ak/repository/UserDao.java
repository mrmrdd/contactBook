package com.ak.repository;

import com.ak.entity.Contact;
import com.ak.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        String queryInsert = "INSERT INTO user_role (user_id, role_id) SELECT u.id, r.id FROM" +
                             " User u, Role r WHERE u.login = " + user.getLogin() + " and r.id = 2";
        getSession().save(user);
    }

    public User getByLogin(String login) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.like("login", login));
        List<User> list = criteria.list();
        User user = list.get(0);
        return user;
    }

    public void setRole(User user){
        String queryInsert = "INSERT INTO user_role (user_id, role_id) SELECT u.id, r.id FROM" +
                             " User u, Role r WHERE u.login = " + user.getLogin() + " and r.id = 2";
        Query query = getSession().createQuery(queryInsert);
        int result = query.executeUpdate();
    }
}
