package com.tw.codesnippet.controller;

import com.tw.codesnippet.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("world")
    public Result<String> helloWorld() {
        return Result.success("Hello, World!");
    }

    @GetMapping("java")
    public Result<String> helloJava() {
        return Result.success("Hello, Java!");
    }
}
