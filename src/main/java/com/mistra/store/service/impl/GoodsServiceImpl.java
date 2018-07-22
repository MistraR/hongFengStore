package com.mistra.store.service.impl;

import com.mistra.store.dao.GoodsRepository;
import com.mistra.store.entity.Goods;
import com.mistra.store.queryVo.GoodsVo;
import com.mistra.store.service.GoodsService;
import com.mistra.store.util.hibernate.PageCondition;
import com.mistra.store.util.hibernate.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public void add(Goods goods) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Goods goods) {

    }

    @Override
    public Pager pageSelect(PageCondition condition, GoodsVo goodsVo) {
        return null;
    }
}