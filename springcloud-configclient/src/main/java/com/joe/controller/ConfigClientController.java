package com.joe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
 
 
    @Value("${testValue}")
    String testValue;
    @RequestMapping(value = "/getTestValue")
    public String getTestValue(){
 
        return "获取到的配置文件值为："+testValue;
    }

    @GetMapping("/refresh")
    public String getRefresh(){
        return "刷新成功！";
    }
 
}