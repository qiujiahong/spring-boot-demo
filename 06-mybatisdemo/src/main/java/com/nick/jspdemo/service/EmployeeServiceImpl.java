package com.nick.jspdemo.service;

import com.nick.jspdemo.bean.Employee;
import com.nick.jspdemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Transactional
    @Override
    public void addEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }
}
