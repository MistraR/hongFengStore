package com.mistra.store.dao;

import com.mistra.store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/20/020
 * Describe:
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);
}
