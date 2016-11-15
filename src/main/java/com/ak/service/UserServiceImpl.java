package com.ak.service;

import com.ak.entity.User;
import com.ak.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MacDuck on 11/4/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public void addUser(User user) {
        dao.save(user);
    }

    @Override
    public User findUserbyName(String name) {
       return dao.getByName(name);
    }

    @Override
    public void updateData(User user) {
        dao.udpate(user);
    }


}
