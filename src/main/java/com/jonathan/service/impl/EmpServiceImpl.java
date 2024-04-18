package com.jonathan.service.impl;

import com.jonathan.mapper.EmpMapper;
import com.jonathan.pojo.Emp;
import com.jonathan.pojo.PageBean;
import com.jonathan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        //1. get the total records
        Long count = empMapper.count();

        //2. get the pagination query result list
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        //3. encapsulate pageBean objects
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }
}
