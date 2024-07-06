package com.tw.codesnippet.service;

import com.tw.codesnippet.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Autowired
 * 1）默认按类型装配
 * 2）如果存在多个同类型实例，再按字段name装配
 * 3）@Qualifier 优于 @Primary
 */
@Service
public class UserSerivce {

    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;

    @Override
    public String toString() {
        return "UserSerivce{" +
            "userDao=" + userDao +
            '}';
    }
}
