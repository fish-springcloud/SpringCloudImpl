package com.github.fish56.cloud.controller;

import com.github.fish56.cloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
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
}
