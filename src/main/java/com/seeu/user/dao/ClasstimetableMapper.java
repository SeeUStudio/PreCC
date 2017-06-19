package com.seeu.user.dao;

import com.seeu.user.model.Classtimetable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ClasstimetableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chosencourses
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @Delete({
        "delete from chosencourses",
        "where userid = #{userid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chosencourses
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @Insert({
        "insert into chosencourses (userid, courseid, ",
        "index)",
        "values (#{userid,jdbcType=VARCHAR}, #{courseid,jdbcType=CHAR}, ",
        "#{index,jdbcType=INTEGER})"
    })
    int insert(Classtimetable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chosencourses
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @InsertProvider(type=ClasstimetableSqlProvider.class, method="insertSelective")
    int insertSelective(Classtimetable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chosencourses
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @Select({
        "select",
        "userid, courseid, index",
        "from chosencourses",
        "where userid = #{userid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="courseid", property="courseid", jdbcType=JdbcType.CHAR),
        @Result(column="index", property="index", jdbcType=JdbcType.INTEGER)
    })
    Classtimetable selectByPrimaryKey(String userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chosencourses
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @UpdateProvider(type=ClasstimetableSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Classtimetable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chosencourses
     *
     * @mbggenerated Mon Jun 19 22:16:49 CST 2017
     */
    @Update({
        "update chosencourses",
        "set courseid = #{courseid,jdbcType=CHAR},",
          "index = #{index,jdbcType=INTEGER}",
        "where userid = #{userid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Classtimetable record);
}