package com.github.fish56.cloud.controller;

import com.github.fish56.cloud.entity.Dept;
import com.github.fish56.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @PostMapping("/depts")
    public Boolean add(@RequestBody Dept dept){
        return service.addDept(dept);
    }

    @GetMapping("/depts")
    public List<Dept> list(){
        return service.findAll();
    }

    @GetMapping("/depts/{id}")
    public Dept dept(@PathVariable Long id){
        return service.findById(id);
    }
}
