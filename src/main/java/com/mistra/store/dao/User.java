package com.mistra.store.dao;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/20/020
 * Describe:
 */
@Entity
@Data
public class User {

    private String username;

    private String password;
}
