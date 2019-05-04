package com.github.fish56.cloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.cloud.entity.Dept;
import com.github.fish56.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/depts/discovery")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();

        System.out.println("*******" + list);
        List<ServiceInstance> instanceList2 = discoveryClient.getInstances("cloud-dept");
        for (ServiceInstance instance : instanceList2){
            System.out.println(JSONObject.toJSONString(instance));
        }
        return this.discoveryClient;
    }
}
