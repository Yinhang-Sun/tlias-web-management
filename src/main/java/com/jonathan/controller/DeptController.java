package com.jonathan.controller;

import com.jonathan.anno.Log;
import com.jonathan.pojo.Dept;
import com.jonathan.pojo.Result;
import com.jonathan.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Department controller
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * list all department
     * @return
     */
    @Log
    @GetMapping
    public Result list() {
        log.info("List all department data");

        // Call DeptService to list all department data
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * delete department
     * @param id
     * @return
     */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("Delete department with id {}", id);
        //Call service to delete department
        deptService.delete(id);
        return Result.success();
    }

    /**
     * add department
     * @return
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("Add department: {}", dept);
        //Call service to add department
        deptService.add(dept);
        return Result.success();
    }

    /**
     * list department by id
     * @param id
     * @return
     */
    @Log
    @GetMapping("/{id}")
    public Result listById(@PathVariable Integer id) {
        log.info("List department with id {}", id);
        //Call service to list department by id
        Dept dept = deptService.listById(id);
        return Result.success(dept);
    }

    /**
     * update department
     * @param dept
     * @return
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("Update department {}", dept);
        //Call service to update department
        deptService.update(dept);
        return Result.success();
    }
}
