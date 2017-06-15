package com.seeu.coursesystem.service;

import com.seeu.coursesystem.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/6/14 0014.
 */
@Mapper
public interface CourseMapper {
    /**
     *
     * 按照id查询课程
     * @param id
     * @return
     */
    Course findByid(@Param("id") String id);

    /**
     * 将课程插入数据库
     * @param course
     * @return
     */
    int insert(Course course);

    /**
     * 实现分页查询，返回一个链表
     * @param page
     * @param limit
     * @return
     */
    ArrayList<String> findByPage(int page, int limit);
}
