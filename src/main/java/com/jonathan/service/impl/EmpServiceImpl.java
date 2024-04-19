package com.jonathan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jonathan.mapper.EmpMapper;
import com.jonathan.pojo.Emp;
import com.jonathan.pojo.PageBean;
import com.jonathan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

//    Method without PageHelper
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //1. get the total records
//        Long count = empMapper.count();
//
//        //2. get the pagination query result list
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//
//        //3. encapsulate pageBean objects
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;
//    }

    //Method with PageHelper
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1.set pagination parameters
        PageHelper.startPage(page, pageSize);

        //2.execute query
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //3. encapsulate pageBean objects
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }

}
