package com.seeu.coursesystem.service;

import com.seeu.user.model.*;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/6/13 0013.
 */
public interface CourseService {
    /**
     * 获取课程全部信息
     * @param course
     * @return
     */
    String getDetailInfo(Course course);

    /**
     * 获取课程最基本的信息
     * @param course
     * @return
     */
    String getBasicInfo(Course course);

    /**
     * 分页查找功能
     * @param userid
     * @param page
     * @param limit
     * @return
     */
    ArrayList<String> findByPage(String userid, int page, int limit);

}
