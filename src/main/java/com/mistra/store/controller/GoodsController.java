package com.mistra.store.controller;

import com.mistra.store.entity.Goods;
import com.mistra.store.queryVo.GoodsVo;
import com.mistra.store.service.GoodsService;
import com.mistra.store.util.hibernate.PageCondition;
import com.mistra.store.util.hibernate.Pager;
import com.mistra.store.util.web.annotation.AddUrl;
import com.mistra.store.util.web.annotation.DeleteUrl;
import com.mistra.store.util.web.annotation.GetOneUrl;
import com.mistra.store.util.web.annotation.UpdateUrl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @AddUrl
    @ApiOperation("新增")
    public void add(Goods goods) {
        goodsService.add(goods);
    }

    @DeleteUrl
    @ApiOperation("删除")
    public void delete(Long id) {
        goodsService.delete(id);
    }

    @GetOneUrl
    @ApiOperation("查询单条")
    public Goods getOne(Long id) {
        return goodsService.findOne(id);
    }

    @UpdateUrl
    @ApiOperation("修改")
    public void update(Goods goods) {
        goodsService.update(goods);
    }

    @RequestMapping("/listSelect")
    @ApiOperation("条件查询、分页")
    public Pager pageSelect(PageCondition condition, GoodsVo goodsVo) {
        return goodsService.pageSelect(condition, goodsVo);
    }
}