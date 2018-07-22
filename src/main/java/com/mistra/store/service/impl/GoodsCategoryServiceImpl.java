package com.mistra.store.service.impl;

import com.mistra.store.dao.GoodsCategoryRepository;
import com.mistra.store.entity.GoodsCategory;
import com.mistra.store.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Autowired
    private GoodsCategoryRepository goodsCategoryRepository;

    @Override
    public void add(GoodsCategory goodsCategory) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(GoodsCategory goodsCategory) {

    }

    @Override
    public List<GoodsCategory> list() {
        return null;
    }
}