package com.jonathan.controller;

import com.jonathan.pojo.Emp;
import com.jonathan.pojo.Result;
import com.jonathan.service.EmpService;
import com.jonathan.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("Employee login : {}", emp);
        Emp e = empService.login(emp);

        //Login successfully, Generate jwt and Issue the token
        if(e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);//jwt contains info of the current logged-in emp
            return Result.success(jwt);
        }

        //Login failed, return error test
        return Result.error("username or password incorrect");
    }
}
