package com.mistra.store.entity;

import com.mistra.store.util.hibernate.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
@Entity
@Data
public class Goods extends BaseEntity {

    @ApiParam("名称")
    private String name;

    @ApiParam("编号")
    private String number;

    @ApiParam("商品所属类目")
    @ManyToOne
    @JoinColumn(name = "Category_id")
    private GoodsCategory goodsCategory;

    @ApiParam("进价")
    private String purchasePrice;

    @ApiParam("批发价")
    private String wholesalePrice;

    @ApiParam("零售价")
    private String retailPrice;

    @ApiParam("单位")
    private String standard;

    @ApiParam("库存情况")
    private String inventorySituation;

    @ApiParam("创建时间")
    protected Date createTime;

    @ApiParam("更新时间")
    protected Date modifyTime;
}