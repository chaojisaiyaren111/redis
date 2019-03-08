package com.springboot.service.impl;


import com.springboot.model.entity.Employee;
import com.springboot.model.mapper.EmployeeMapper;
import com.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 西安海汇防务科技有限公司
 * Copyright (c) 2018, tianta All Rights Reserved.
 * Created by xiejiayi on 2019/2/14.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    //@Cacheable(cacheNames = {"emp","ax"})
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.entityById(id);
       redisTemplate.opsForValue().set("key1",employee,1000, TimeUnit.SECONDS);
        Employee employee12 = (Employee) redisTemplate.opsForValue().get("key1");
        System.out.println(employee12.toString());
        return employee;
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return employee;
    }


    @Override
    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmp(id);
    }


    @Override
    public Employee getByLastName(String lastName) {
        return employeeMapper.getByLastName(lastName);
    }


}
