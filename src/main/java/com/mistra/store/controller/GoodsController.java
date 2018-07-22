package com.mistra.store.controller;

import com.mistra.store.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

}