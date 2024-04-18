package com.jonathan.mapper;

import com.jonathan.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * query total records
     * @return
     */
    //@Select("select count(*) from emp")
    //public Long count();

    /**
     * pagination query, to get data list
     * @param start
     * @param pageSize
     * @return
     */
    //@Select("select * from emp limit #{start}, #{pageSize}")
    //public List<Emp> page(Integer start, Integer pageSize);

    /**
     * employee query
     * @return
     */
    //@Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * Batch delete employees
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * Add new employees
     * @param emp
     */
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);
}
