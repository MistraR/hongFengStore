package com.mistra.store.dao;

import com.mistra.store.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
public interface GoodsRepository extends JpaRepository<Goods,Long> {
}
