package com.sample.db.mapper;


import com.sample.db.pojos.Genre;
import com.sample.db.pojos.GenreExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GenreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    int countByExample(GenreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    int deleteByExample(GenreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    @Delete({
        "delete from Genre",
        "where GenreId = #{genreid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer genreid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    @Insert({
        "insert into Genre (GenreId, Name)",
        "values (#{genreid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Genre record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    int insertSelective(Genre record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    List<Genre> selectByExample(GenreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    @Select({
        "select",
        "GenreId, Name",
        "from Genre",
        "where GenreId = #{genreid,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Genre selectByPrimaryKey(Integer genreid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    int updateByExampleSelective(@Param("record") Genre record, @Param("example") GenreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    int updateByExample(@Param("record") Genre record, @Param("example") GenreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    int updateByPrimaryKeySelective(Genre record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Genre
     *
     * @mbggenerated Thu Jun 05 12:50:06 CEST 2014
     */
    @Update({
        "update Genre",
        "set Name = #{name,jdbcType=VARCHAR}",
        "where GenreId = #{genreid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Genre record);
}
