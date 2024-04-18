package com.jonathan.service;

import com.jonathan.pojo.Emp;
import com.jonathan.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * employee service
 */
public interface EmpService {
    /**
     * pagination query
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * Batch delete employees
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * Add new employees
     * @param emp
     */
    void save(Emp emp);
}
