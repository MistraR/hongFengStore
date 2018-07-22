package com.mistra.store.entity;

import com.mistra.store.util.hibernate.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
@Entity
@Data
public class GoodsCategory extends BaseEntity {

    private String name;

}