package com.jonathan.service;

import com.jonathan.pojo.PageBean;

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
    PageBean page(Integer page, Integer pageSize);
}
