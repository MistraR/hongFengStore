package com.mistra.store.service;

import com.mistra.store.entity.Goods;
import com.mistra.store.queryVo.GoodsVo;
import com.mistra.store.util.hibernate.PageCondition;
import com.mistra.store.util.hibernate.Pager;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
public interface GoodsService {

    void add(Goods goods);

    void delete(Long id);

    Goods findOne(Long id);

    void update(Goods goods);

    Pager pageSelect(PageCondition condition,GoodsVo goodsVo);

}
