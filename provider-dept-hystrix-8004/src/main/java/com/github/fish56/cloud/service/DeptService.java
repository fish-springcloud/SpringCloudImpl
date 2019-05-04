package com.github.fish56.cloud.service;

import com.github.fish56.cloud.entity.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAll();
}
