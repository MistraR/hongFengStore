package com.mistra.store.util.web.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * Author: WangRui
 * Date: 2018/6/6
 * Describe: 列表查询所有数据方法RequestMapping注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(value = "/listAll", method = RequestMethod.GET)
public @interface ListAllUrl {
}
