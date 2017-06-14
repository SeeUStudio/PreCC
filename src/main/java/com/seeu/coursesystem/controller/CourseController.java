package com.seeu.coursesystem.controller;

import com.CODE;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seeu.coursesystem.domain.Course;
import com.seeu.coursesystem.service.CourseMapper;
import com.seeu.coursesystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by thinkpad on 2017/6/13 0013.
 */
@RequestMapping("/course")
@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    TurnBackUtil turnBackUtil;
    @Autowired
    CourseMapper courseMapper;

    @RequestMapping(value = "/nessinfo?id={id}", method = RequestMethod.GET)
    public String getCourseInfo(@PathVariable Long id){
        Course course = courseMapper.findByid(id);
        try{
        if(course != null){
            return turnBackUtil.formIt(CODE.SUCCESS
                    , "查询成功", JSON.toJSONString(course));
        }
        else
            return turnBackUtil.formIt(CODE.BLANK, "查询成功，数据为空",null);
        }catch(Exception e){
            return turnBackUtil.formIt(CODE.FAILURE, "查询失败", null);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCourse(@RequestParam("course") String courseStr){
        Course course = JSONObject.parseObject(courseStr,Course.class);
        try{
            Long id = course.getCourseid();
            String code = course.getCode();
            String name = course.getName();
            String day = course.getDay();
            String time = course.getDay();
            String location = course.getLocation();
            String teacher = course.getTeacher();
            int credit = course.getCredit();
            String week = course.getWeek();

            if(id == null || code == null || name == null || day == null
                    || time == null || location == null || teacher == null
                    || week == null ){
                return turnBackUtil.formIt(CODE.FAILURE, "信息不全无法创建",null);
            }
             Course exCourse = courseMapper.findByid(id);
            if(exCourse != null){
                return  turnBackUtil.formIt(CODE.FAILURE, "该课程已被注册",null);
            }

            int flag = courseMapper.insert(course);
            if(flag == 1){
                return turnBackUtil.formIt(CODE.SUCCESS, "创建成功", JSON.toJSONString(course));
            }
            else{
                return turnBackUtil.formIt(CODE.FAILURE, "创建失败，请联系管理员", null);
            }
        }catch (Exception e){
            return turnBackUtil.formIt(CODE.FAILURE, "创建失败", null);
        }

    }




}
