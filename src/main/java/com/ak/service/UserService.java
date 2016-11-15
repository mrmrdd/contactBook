package com.ak.service;

import com.ak.entity.User;
import com.ak.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MacDuck on 11/2/16.
 */
public interface UserService {

    void addUser(User user);

    User findByLogin(String name);

    void updateData(User user);
}
