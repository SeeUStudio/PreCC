package com.seeu.user.model;

public class UserCourse extends GeneralCourse {
   private String userid;

    public UserCourse(String courseid, String code, String name, String teacher, Integer credit, String week, String day_detail1, String day_detail2, String location, Integer remaining, Integer total, String extra, Integer index) {
        super(courseid, code, name, teacher, credit, week, day_detail1, day_detail2, location, remaining, total, extra, index);
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}