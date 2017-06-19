package com.seeu.mainsystem.service;

import com.seeu.user.model.GeneralCourse;

import java.util.List;

/**
 * Created by thinkpad on 2017/6/19 0019.
 */
public interface CourseSevice {
    List<GeneralCourse> findBypage(int page, int limit, String userid);
    String getInfo(GeneralCourse course);
    String getDetailInfo(GeneralCourse course);
    String getUUID();
}
