package com.joe.controller;

import com.joe.config.DataSourceConfiguration;
import com.joe.config.GitAutoRefreshConfig;
import com.joe.config.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GitController {

    @Autowired
    private GitConfig gitConfig;

    @Autowired
    private GitAutoRefreshConfig gitAutoRefreshConfig;

    @Autowired
    private DataSourceConfiguration dataSourceConfiguration;

    @GetMapping(value = "show")
    public Object show(){
        return gitConfig;
    }

    @GetMapping(value = "autoShow")
    public Object autoShow(){
        return gitAutoRefreshConfig;
    }

    @GetMapping(value = "autoDataShow")
    public Object autoDataShow(){
        return dataSourceConfiguration.getUrl();
    }
}