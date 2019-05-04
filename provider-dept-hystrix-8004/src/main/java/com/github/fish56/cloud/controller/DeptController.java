package com.github.fish56.cloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.cloud.entity.Dept;
import com.github.fish56.cloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @HystrixCommand(fallbackMethod = "hystrixGetList")
    // 抛出异常后调用fallbackMethod
    public List<Dept> list(){
        throw new RuntimeException();
        //return service.findAll();
    }

    private List<Dept> hystrixGetList(){
        Dept dept = new Dept().setDb_source("error");
        List<Dept> list = new ArrayList<>();
        list.add(dept);
        return list;
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
