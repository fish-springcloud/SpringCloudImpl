package com.github.fish56.cloud.controller;

import com.github.fish56.cloud.entity.Dept;
import com.github.fish56.cloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptControllerConsumer {

    @Autowired
    private DeptClientService deptClientService;

    @GetMapping("/consumer/depts")
    public List<Dept> getAll(Dept dept){
        return deptClientService.findAll();
    }

}
