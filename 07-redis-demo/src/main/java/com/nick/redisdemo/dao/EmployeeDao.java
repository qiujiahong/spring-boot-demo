package com.nick.redisdemo.dao;


import com.nick.redisdemo.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao {

    void insertEmployee(Employee employee) ;

    Integer selectEmployeeCount();

    Employee selectEmployeeById(int id);
}
