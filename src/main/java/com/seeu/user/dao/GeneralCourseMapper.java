package com.seeu.user.dao;

import com.seeu.user.model.GeneralCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface GeneralCourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table generalcourseinformation
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @Delete({
        "delete from generalcourseinformation",
        "where courseid = #{courseid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String courseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table generalcourseinformation
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @Insert({
        "insert into generalcourseinformation (courseid, code, ",
        "name, teacher, credit, ",
        "week, day_detail1, ",
        "day_detail2, location, ",
        "remaining, total, ",
        "extra, index)",
        "values (#{courseid,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{teacher,jdbcType=VARCHAR}, #{credit,jdbcType=INTEGER}, ",
        "#{week,jdbcType=VARCHAR}, #{day_detail1,jdbcType=VARCHAR}, ",
        "#{day_detail2,jdbcType=VARCHAR}, #{location,jdbcType=VARCHAR}, ",
        "#{remaining,jdbcType=INTEGER}, #{total,jdbcType=INTEGER}, ",
        "#{extra,jdbcType=VARCHAR}, #{index,jdbcType=INTEGER})"
    })
    int insert(GeneralCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table generalcourseinformation
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @InsertProvider(type=GeneralCourseSqlProvider.class, method="insertSelective")
    int insertSelective(GeneralCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table generalcourseinformation
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @Select({
        "select",
        "courseid, code, name, teacher, credit, week, day_detail1, day_detail2, location, ",
        "remaining, total, extra, index",
        "from generalcourseinformation",
        "where courseid = #{courseid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="courseid", property="courseid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher", property="teacher", jdbcType=JdbcType.VARCHAR),
        @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER),
        @Result(column="week", property="week", jdbcType=JdbcType.VARCHAR),
        @Result(column="day_detail1", property="day_detail1", jdbcType=JdbcType.VARCHAR),
        @Result(column="day_detail2", property="day_detail2", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="remaining", property="remaining", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.INTEGER),
        @Result(column="extra", property="extra", jdbcType=JdbcType.VARCHAR),
        @Result(column="index", property="index", jdbcType=JdbcType.INTEGER)
    })
    GeneralCourse selectByPrimaryKey(String courseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table generalcourseinformation
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @UpdateProvider(type=GeneralCourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GeneralCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table generalcourseinformation
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @Update({
        "update generalcourseinformation",
        "set code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "teacher = #{teacher,jdbcType=VARCHAR},",
          "credit = #{credit,jdbcType=INTEGER},",
          "week = #{week,jdbcType=VARCHAR},",
          "day_detail1 = #{day_detail1,jdbcType=VARCHAR},",
          "day_detail2 = #{day_detail2,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=VARCHAR},",
          "remaining = #{remaining,jdbcType=INTEGER},",
          "total = #{total,jdbcType=INTEGER},",
          "extra = #{extra,jdbcType=VARCHAR},",
          "index = #{index,jdbcType=INTEGER}",
        "where courseid = #{courseid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(GeneralCourse record);
    @Select({
            "select",
            "courseid, code, name, teacher, credit, week, day_detail1, day_detail2, location, ",
            "remaining, total, extra, index",
            "from generalcourseinformation"
    })
    @Results({
            @Result(column="courseid", property="courseid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="teacher", property="teacher", jdbcType=JdbcType.VARCHAR),
            @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER),
            @Result(column="week", property="week", jdbcType=JdbcType.VARCHAR),
            @Result(column="day_detail1", property="day_detail1", jdbcType=JdbcType.VARCHAR),
            @Result(column="day_detail2", property="day_detail2", jdbcType=JdbcType.VARCHAR),
            @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
            @Result(column="remaining", property="remaining", jdbcType=JdbcType.INTEGER),
            @Result(column="total", property="total", jdbcType=JdbcType.INTEGER),
            @Result(column="extra", property="extra", jdbcType=JdbcType.VARCHAR),
            @Result(column="index", property="index", jdbcType=JdbcType.INTEGER)
    })
    List<GeneralCourse> selectAll();
}