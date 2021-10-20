/*
 * Copyright (c) 2021
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.student.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;

/**
 * Mapper to handle student course addition and deletion 
 * @author Senthil M
 *
 */
@Mapper
public interface StudentCourseMapper {

	@Insert("INSERT INTO STUDENT(CREATE_DTM, LAST_MODIFIED_DTM, STUDENT_ID, STUDENT_NAME, COURSE_SCORE, COURSE_ID )"
			+ " VALUES ( CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, #{studentId}, #{studentName}, #{courseScore}, #{courseID} )")
	int insertStudent(@Param("studentName") String studentName, @Param("studentId") Double studentId, @Param("courseScore") String courseScore, @Param("courseID") Double courseID);

	@Delete("DELETE FROM STUDENT STU"
			+ " WHERE STU.STUDENT_ID IN (#{ids[0]}, #{ids[1]}, #{ids[2]}, #{ids[3]}, #{ids[4]}, #{ids[5]}, #{ids[6]}, #{ids[7]}, #{ids[8]}, #{ids[9]},"
			+ " #{ids[10]}, #{ids[11]}, #{ids[12]}, #{ids[13]}, #{ids[14]}, #{ids[15]}, #{ids[16]}, #{ids[17]}, #{ids[18]}, #{ids[19]},"
			+ " #{ids[20]}, #{ids[21]}, #{ids[22]}, #{ids[23]}, #{ids[24]}, #{ids[25]}, #{ids[26]}, #{ids[27]}, #{ids[28]}, #{ids[29]},"
			+ " #{ids[30]}, #{ids[31]}, #{ids[32]}, #{ids[33]}, #{ids[34]}, #{ids[35]}, #{ids[36]}, #{ids[37]}, #{ids[38]}, #{ids[39]},"
			+ " #{ids[40]}, #{ids[41]}, #{ids[42]}, #{ids[43]}, #{ids[44]}, #{ids[45]}, #{ids[46]}, #{ids[47]}, #{ids[48]}, #{ids[49]})")
	int deleteStudent(@Param("ids") List<Double> ids);

	@Select("SELECT STUDENT_NAME"
			+ " FROM STUDENT"
			+ " WHERE COURSE_ID IN (SELECT COURSE_ID FROM COURSE WHERE COURSE_NAME IN (#{ids[0]}, #{ids[1]}, #{ids[2]}, #{ids[3]}, #{ids[4]}, #{ids[5]},"
			+ " #{ids[6]}, #{ids[7]}, #{ids[8]}, #{ids[9]}, #{ids[10]}, #{ids[11]},"
			+ " #{ids[12]}, #{ids[13]}, #{ids[14]}, #{ids[15]}, #{ids[16]}, #{ids[17]},"
			+ " #{ids[18]}, #{ids[19]}, #{ids[20]}))"
			+ " AND CREATE_DTM < (#{fourteenDaysOld})"
			+ " ORDER BY STUDENT_NAME ASCE"
			+ " WITH UR")
	Cursor<String> selectAllStudentWithCourseId(@Param("ids") List<String> ids);
	
	@Select("SELECT STUDENT_NAME"
			+ " FROM STUDENT"
			+ " WHERE COURSE_ID IS NULL)"
			+ " WITH UR")
	Cursor<String> selectAllStudentWithOutCourseId();

}
