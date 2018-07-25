package com.mistra.store.dao;

import com.mistra.store.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author: RoronoaZoro丶WangRui
 * Time: 2018/7/22/022
 * Describe:
 */
public interface GoodsRepository extends JpaRepository<Goods,Long> {

    @Query(value = "select *  from goods where name like ?1 or number like ?2 order by create_time ASC limit ?3,?4",nativeQuery = true)
    List<Goods> nativeSql(String name,String number,int start,int end);
}
