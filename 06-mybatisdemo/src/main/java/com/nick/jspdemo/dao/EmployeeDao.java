package com.nick.jspdemo.dao;


import com.nick.jspdemo.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao {

    void insertEmployee(Employee employee) ;
}
