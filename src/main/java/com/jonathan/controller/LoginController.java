package com.jonathan.controller;

import com.jonathan.pojo.Emp;
import com.jonathan.pojo.Result;
import com.jonathan.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("Employee login : {}", emp);
        Emp e = empService.login(emp);
        return e != null ? Result.success() : Result.error("username or password incorrect");
    }
}
