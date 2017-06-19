package com.seeu.mainsystem.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seeu.user.dao.GeneralCourseMapper;
import com.seeu.user.dao.UserCourseMapper;
import com.seeu.user.model.GeneralCourse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by thinkpad on 2017/6/19 0019.
 */
public class CourseServiceImp implements CourseSevice {
    @Autowired
    GeneralCourseMapper generalCourseMapper;
    @Autowired
    UserCourseMapper userCourseMapper;


    @Override
    public List<GeneralCourse> findBypage(int page, int limit, String userid) {
        List<GeneralCourse> generalCourses = generalCourseMapper.selectAll();
        List<GeneralCourse> userCourses = userCourseMapper.selectByUserid(userid);
        Iterator iterator = userCourses.iterator();
        while(iterator.hasNext())
            generalCourses.add((GeneralCourse) iterator.next());
        return generalCourses;
    }

    @Override
    public String getDetailInfo(GeneralCourse course) {
        return JSON.toJSONString(course);
    }

    @Override
    public String getInfo(GeneralCourse course) {
        JSONObject object = new JSONObject();
        object.put("courseid",course.getCourseid());
        object.put("code", course.getCode());
        object.put("name", course.getName());
        object.put("day_detail1", course.getDay_detail1());
        object.put("day_detail2", course.getDay_detail2());
        object.put("teacher", course.getTeacher());
        object.put("location", course.getLocation());
        object.put("credit", course.getCredit());
        object.put("week", course.getWeek());
        object.put("remaining", course.getRemaining());
        object.put("total", course.getTotal());
        return object.toJSONString();
    }

    @Override
    public String getUUID() {
        UUID uuid= UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
}
