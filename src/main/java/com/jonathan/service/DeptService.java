package com.jonathan.service;

import com.jonathan.pojo.Dept;

import java.util.List;

/**
 * department service
 */

public interface DeptService {
    /**
     * List all department data
     * @return
     */
    List<Dept> list();

    /**
     * Delete department
     * @param id
     */
    void delete(Integer id) throws Exception;

    /**
     * add department
     * @param dept
     */
    void add(Dept dept);

    /**
     * list department by id
     * @param id
     * @return
     */
    Dept listById(Integer id);

    /**
     * update department
     * @param dept
     */
    void update(Dept dept);
}
