package com.jonathan.mapper;

import com.jonathan.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * query total records
     * @return
     */
    @Select("select count(*) from emp")
    public Long count();

    /**
     * pagination query, to get data list
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select * from emp limit #{start}, #{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);
}
