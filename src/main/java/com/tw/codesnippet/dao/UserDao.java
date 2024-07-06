package com.tw.codesnippet.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private Integer id;

    public UserDao() {

    }

    public UserDao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDao{" +
            "id=" + id +
            '}';
    }
}
