package com.mistra.store.entity;

import com.mistra.store.util.hibernate.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/20/020
 * Describe:
 */
@Entity
@Data
public class User extends BaseEntity {

    private String username;

    private String password;
}
