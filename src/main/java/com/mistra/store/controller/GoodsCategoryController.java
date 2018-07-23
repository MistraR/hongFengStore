package com.mistra.store.controller;

import com.mistra.store.entity.GoodsCategory;
import com.mistra.store.service.GoodsCategoryService;
import com.mistra.store.util.web.annotation.AddUrl;
import com.mistra.store.util.web.annotation.ListAllUrl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
@Controller
@RequestMapping("/category")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @AddUrl
    @ApiOperation("新增/修改")
    public void add(GoodsCategory goodsCategory) {
        goodsCategoryService.add(goodsCategory);
    }

    @ListAllUrl
    @ApiOperation("查询全部类目")
    public String listAll(HttpServletRequest request) {
        request.setAttribute("goodsCategoryList", goodsCategoryService.list());
        return "index";
    }

}