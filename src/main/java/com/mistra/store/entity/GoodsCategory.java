package com.mistra.store.entity;

import com.mistra.store.util.hibernate.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
@Entity
@Data
public class GoodsCategory extends BaseEntity {

    private String name;

    @ApiParam("创建时间")
    protected Date createTime;

    @ApiParam("更新时间")
    protected Date modifyTime;
}