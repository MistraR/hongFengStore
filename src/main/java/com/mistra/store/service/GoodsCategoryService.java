package com.mistra.store.service;

import com.mistra.store.entity.GoodsCategory;

import java.util.List;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
public interface GoodsCategoryService {

    void add(GoodsCategory goodsCategory);

    void delete(Long id);

    void update(GoodsCategory goodsCategory);

    List<GoodsCategory> list();

}