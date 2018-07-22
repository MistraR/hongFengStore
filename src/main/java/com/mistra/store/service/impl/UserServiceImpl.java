package com.mistra.store.service.impl;

import com.mistra.store.dao.UserRepository;
import com.mistra.store.entity.User;
import com.mistra.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/20/020
 * Describe:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(User user) {
        User user1 = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (user1 != null) {
            return true;
        } else {
            return false;
        }
    }
}
