package com.seeu.mainsystem.controller;

import com.CODE;
import com.TurnBackUtil;
import com.alibaba.fastjson.JSON;
import com.seeu.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by thinkpad on 2017/6/13 0013.
 */
@RequestMapping("/course")
@RestController
public class CourseController {
    @Autowired
    TurnBackUtil turnBackUtil;

    GeneralCourse c1 = new GeneralCourse("123", "CS101", "3-1-2",
            "LAOLUO", "LIYUAN", 100, 120,1,
            "1,3,5,7,9" , "4-1-2", "",3);
    GeneralCourse c2 = new GeneralCourse("124", "CS102", "3-3-4",
            "wangqi", "LIYUAN", 100, 120,2,
            "1,3,5,7,9" , "4-3-4","",2);
    GeneralCourse c3 = new GeneralCourse("125", "CS104", "5-1-2",
            "LAOLUO", "LIYUAN", 100, 120,3,
            "1,3,5,7,9" , "1-1-2", "",2);
    GeneralCourse c4 = new GeneralCourse("126", "CS201", "5-1-2",
            "LAOLUO", "LIYUAN", 100, 120,4,
            "1,3,5,7,9" , "1-1-2","",3);
    GeneralCourse c5 = new GeneralCourse("202", "CS202", "5-1-2",
            "LAOLUO", "LIYUAN", 100, 120,5,
            "2,4,6,8,10" , "1-1-2", "",4);
    GeneralCourse c6 = new GeneralCourse("203", "CS203", "3-3-4",
            "LAOLUO", "LIYUAN", 100, 120,6,
            "2,4,6,8,10" , "4-3-4", "",3);
    GeneralCourse c7 = new GeneralCourse("204", "CS204", "3-3-4",
            "LAOLUO", "LIYUAN", 100, 120,7,
            "2,4,6,8,10,12,14" , "4-3-4", "",4);
    GeneralCourse c8 = new GeneralCourse("205", "CS205", "2-5-6",
            "LAOLUO", "LIYUAN", 100, 120,7,
            "1,3,5,7,9" , "1-5-6", "",3);
    GeneralCourse c9 = new GeneralCourse("206", "CS206", "5-1-2",
            "LAOLUO", "LIYUAN", 100, 120,7,
            "1,3,5,7,9" , "1-5-6", "",3);
    GeneralCourse c10 = new GeneralCourse("301", "CS301", "5-1-2",
            "LAOLUO", "LIYUAN", 100, 120,7,
            "1,3,5,7,9,11" , "1-7-8", "",3);
    String s1 = JSON.toJSONString(c1);
    String s2 = JSON.toJSONString(c2);
    String s3 = JSON.toJSONString(c3);
    String s4 = JSON.toJSONString(c4);
    String s5 = JSON.toJSONString(c5);
    String s6 = JSON.toJSONString(c6);
    String s7 = JSON.toJSONString(c7);
    String s8 = JSON.toJSONString(c8);
    String s9 = JSON.toJSONString(c9);
    String s10 = JSON.toJSONString(c10);

    @RequestMapping(value = "/item?page={page}&limit={limit}", method = RequestMethod.GET)
    public String getPageCourses(@RequestParam("user") String userid, @PathVariable int page, @PathVariable int limit){
        /*ArrayList<String> courses = new ArrayList<>();
        courses = courseService.findByPage(userid, page, limit);
        try{
        if(courses == null){
            return turnBackUtil.formIt(CODE.CREATED, "查询成功，数据为空", null);
        }
        else {
            return turnBackUtil.formIt(CODE.SUCCESS, "查询成功", courses);
        }
        }catch (Exception e){
            return turnBackUtil.formIt(CODE.FAILURE, "失败,请联系管理员", null);
        }*/
        String[] courses = {s1,s2,s3,s4,s5,s5,s6,s7,s8,s9,s10};
        return turnBackUtil.formIt(CODE.SUCCESS, "SUCCESS", courses);
    }

    @RequestMapping(value = "/nessinfo?id={id}", method = RequestMethod.GET)
    public String getNessInfo(@RequestParam("user") String userid, @PathVariable String id){
       /*Course course = courseMapper.selectByPrimaryKey(id);
        try{
        if(course != null){
            return turnBackUtil.formIt(CODE.SUCCESS
                    , "查询成功", courseService.getBasicInfo(course));
        }
        else
            return turnBackUtil.formIt(CODE.CREATED, "查询成功，数据为空",null);
        }catch(Exception e){
            return turnBackUtil.formIt(CODE.FAILURE, "查询失败", null);
        }*/
       return turnBackUtil.formIt(CODE.SUCCESS, "success", s1);
    }

    @RequestMapping(value = "/info?id={id}", method = RequestMethod.GET)
    public String getDetailInfo(@PathVariable String id){
       /* Course course = courseMapper.selectByPrimaryKey(id);
        try{
            if(course != null){
                return turnBackUtil.formIt(CODE.SUCCESS
                        , "查询成功", courseService.getDetailInfo(course));
            }
            else
                return turnBackUtil.formIt(CODE.CREATED, "查询成功，数据为空",null);
        }catch(Exception e){
            return turnBackUtil.formIt(CODE.FAILURE, "查询失败", null);
        }*/
       return turnBackUtil.formIt(CODE.SUCCESS,"success", s2);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCourse(@RequestParam("course") String courseStr){
        /*Course course = JSONObject.parseObject(courseStr,Course.class);
        try{
            String id = course.getCourseid();
            String code = course.getCode();
            String name = course.getName();
            String day = course.getDay();
            String time = course.getDay();
            String location = course.getLocation();
            String teacher = course.getTeacher();
            int credit = course.getCredit();
            String week = course.getWeek();
            String user = course.getUser();

            if(id == null || code == null || name == null || day == null
                    || time == null || location == null || teacher == null
                    || week == null || user == null){
                return turnBackUtil.formIt(CODE.ACCEPTED, "信息不全无法创建",null);
            }

             Course exCourse = courseMapper.selectByPrimaryKey(id);
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
        }*/
        return turnBackUtil.formIt(CODE.SUCCESS, "success", JSON.toJSONString(courseStr));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("courseid") String courseidStr){
        return turnBackUtil.formIt(CODE.SUCCESS, "success", courseidStr);
    }

}
