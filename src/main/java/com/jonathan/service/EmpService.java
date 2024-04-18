package com.jonathan.service;

import com.jonathan.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
}
