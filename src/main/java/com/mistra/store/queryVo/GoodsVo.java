package com.mistra.store.queryVo;

import io.swagger.annotations.ApiParam;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
public class GoodsVo {

    @ApiParam("名称")
    private String name;

    @ApiParam("编号")
    private String number;

    @ApiParam("商品所属类目")
    private String goodsCategory;
}