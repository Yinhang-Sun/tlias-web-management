package com.jonathan.service.impl;

import com.jonathan.mapper.DeptMapper;
import com.jonathan.mapper.EmpMapper;
import com.jonathan.pojo.Dept;
import com.jonathan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)//rollback for all exceptions
    @Override
    public void delete(Integer id) throws Exception {
        deptMapper.deleteById(id);//delete department based on id

        //int i = 1 / 0;//Runtime exception
        if (true) {
            throw new Exception("Something wrong!");//not runtime exception
        }

        empMapper.deleteByDeptId(id);//delete employees based on department id
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public Dept listById(Integer id) {
        return deptMapper.listById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.update(dept);
    }
}
