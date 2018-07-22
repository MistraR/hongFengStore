package com.mistra.store.service.impl;

import com.mistra.store.dao.GoodsRepository;
import com.mistra.store.entity.Goods;
import com.mistra.store.queryVo.GoodsVo;
import com.mistra.store.service.GoodsService;
import com.mistra.store.util.hibernate.PageCondition;
import com.mistra.store.util.hibernate.Pager;
import com.mistra.store.util.hibernate.QueryHelper;
import com.mistra.store.util.hibernate.dao.CommonDAO;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private CommonDAO commonDAO;

    @Override
    public void add(Goods goods) {
        goodsRepository.save(goods);
    }

    @Override
    public void delete(Long id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public Goods findOne(Long id) {
        return goodsRepository.findById(id).get();
    }

    @Override
    public void update(Goods goods) {
        goodsRepository.save(goods);
    }

    @Override
    public Pager pageSelect(PageCondition condition, GoodsVo goodsVo) {
        QueryHelper helper = new QueryHelper(Goods.class)
                .addCondition(StringUtils.isNotBlank(goodsVo.getName()), "name like %" + goodsVo.getName() + "%")
                .addCondition(StringUtils.isNotBlank(goodsVo.getNumber()), "number like %" + goodsVo.getNumber() + "%")
                .addCondition(StringUtils.isNotBlank(goodsVo.getGoodsCategory()), "category like %" + goodsVo.getGoodsCategory() + "%")
                .setPageCondition(condition)
                .useNativeSql(false);
        Pager pager = commonDAO.findPager(helper);
        return pager;
    }
}