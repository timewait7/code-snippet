package com.tw.codesnippet.po;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
