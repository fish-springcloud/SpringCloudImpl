package com.github.fish56.cloud.service;

import com.github.fish56.cloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// 自动生成REST客户端
//   这种思路太机智了
@FeignClient(value = "CLOUD-DEPT")
public interface DeptClientService {

//    public boolean addDept(Dept dept);
//    public Dept findById(Long id);

    @GetMapping("/depts")
    public List<Dept> findAll();
}
