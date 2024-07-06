package com.tw.codesnippet.service;

import com.tw.codesnippet.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Autowired
 * 0) Spring 中的注解
 * 1）默认按类型装配
 * 2）如果存在多个同类型实例，再按字段name装配
 * 3）@Qualifier 优于 @Primary
 *
 * @Reource
 * 1) Java JSR250 规范中的注解
 * 2）默认按名称装配
 * 3）不能和 @Primary 配合使用
 */
@Service
public class UserSerivce {

    // @Qualifier("userDao")
    // @Autowired
    @Resource
    private UserDao userDao;

    @Override
    public String toString() {
        return "UserSerivce{" +
            "userDao=" + userDao +
            '}';
    }
}
