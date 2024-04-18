package com.jonathan.mapper;

import com.jonathan.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * list all department data
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * Delete department by id
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * add department
     * @param dept
     */
    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /**
     * list department by id
     * @param id
     * @return
     */
    @Select("select * from dept where id = #{id}")
    Dept listById(Integer id);

    /**
     * update department
     * @param dept
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
