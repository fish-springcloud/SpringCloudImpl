package com.github.fish56.cloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.fish56.cloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptControllerConsumer {
    private static final String REST_URL_PROVIDER
            = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/depts")
    public boolean add(Dept dept){
        return restTemplate.postForObject(
                REST_URL_PROVIDER + "/depts", dept, Boolean.class);
    }

    @GetMapping("/consumer/depts/{id}")
    public Dept get(@PathVariable Long id){
        return restTemplate.getForObject(
                REST_URL_PROVIDER + "/depts/" + id, Dept.class);
    }

    @GetMapping("/consumer/depts")
    public List<Dept> getAll(Dept dept){
        return restTemplate.getForObject(
                REST_URL_PROVIDER + "/depts", List.class);
    }

    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/depts/discovery")
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
