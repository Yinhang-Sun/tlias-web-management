package com.jonathan.controller;

import com.jonathan.pojo.PageBean;
import com.jonathan.pojo.Result;
import com.jonathan.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * employee controller
 */
@Slf4j
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("pagination query, parameters: {}, {}", page, pageSize);

        PageBean pageBean = empService.page(page, pageSize);
        return Result.success(pageBean);

    }
}
