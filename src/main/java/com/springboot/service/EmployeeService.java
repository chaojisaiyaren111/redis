package com.springboot.service;


import com.springboot.model.entity.Employee;

/**
 * 西安海汇防务科技有限公司
 * Copyright (c) 2018, tianta All Rights Reserved.
 * Created by xiejiayi on 2019/2/14.
 */
public interface EmployeeService {

    Employee getEmp(Integer id);

    Employee updateEmployee(Employee employee);

    void deleteEmp(Integer id);

    Employee getByLastName(String lastName);






   /* void insertEmp(Department department);

    void deleteEmp();

    void */
}
