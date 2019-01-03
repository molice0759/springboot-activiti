package com.molice.springbootactiviti.controller;

import com.molice.springbootactiviti.entity.Test;
import com.molice.springbootactiviti.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Resource
    private TestService testService;

    @GetMapping("test")
    public Object test() {
        return "test!";
    }

    @GetMapping("test1")
    public Object testData() {
        List<Test> test = testService.findAll();
        return test;
    }
}
