/*
 * Copyright (c) 2021
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.student.course.service;

import java.util.List;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.student.course.repository.StudentCourseRepository;


/**Service class to handle STUDENT and COURSE table
 *  * @author Senthil M
 *
 */
@Service
public class StudentCourseService {
	@Autowired
	private StudentCourseRepository studentCourseRepository;
	
	private static final XLogger LOGGER = XLoggerFactory.getXLogger(StudentCourseService.class);
	
 public List<?> getAllStudent() {
     List ls = null;
	 return ls;
 }
}
