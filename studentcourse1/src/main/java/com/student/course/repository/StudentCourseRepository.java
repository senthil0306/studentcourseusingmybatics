/*
 * Copyright (c) 2021
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.student.course.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.cursor.Cursor;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.student.course.common.StudentCourseCommonUtils;
import com.student.course.common.StudentCourseConstantsutils;
import com.student.course.mapper.StudentCourseMapper;

/**Repository class to handle STUDENT and COURSE table
 *  * @author Senthil M
 *
 */
@Component
public class StudentCourseRepository {
	private final StudentCourseMapper studentCourseMapper;
	private static final XLogger LOGGER = XLoggerFactory.getXLogger(StudentCourseRepository.class);

	@Autowired
	public StudentCourseRepository(final StudentCourseMapper studentCourseMapper) {
		this.studentCourseMapper = studentCourseMapper;
	}
	public Cursor<String> getAllStudentWithCourseId(List<String> name) {
		return studentCourseMapper.selectAllStudentWithCourseId(name);
	}
	public Cursor<String> getAllStudentWithOutCourseId() {
		return studentCourseMapper.selectAllStudentWithOutCourseId();
	}

	public int insertStudent(String studentName, Double studentId, String courseScore, Double courseID) {
		int results = 0;
		try {
			results = studentCourseMapper.insertStudent(studentName, studentId, courseScore, courseID);
		}
		catch (Exception e) {
			//LOGGER.error("Orphan Household Service: Object Id is duplicate {} - ", objectId);
			return 0;
		}
		return results;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int deleteStudent(List<Double> someOIDs, Integer numberOfRows) {
		String listString = null;

		if (LOGGER.isDebugEnabled()) {
			listString = someOIDs.stream().map(Object::toString).collect(Collectors.joining(", "));
		}
		LOGGER.debug("Repository: Deleting rows from student OIDs {}", listString);
		int processedCount = 0;
		Boolean done = false;
		int deleteStudentParentCount = 0;
		while (!done) {
			List<Double> subList = someOIDs.subList(processedCount, Math.min(someOIDs.size(), deleteStudentParentCount + StudentCourseConstantsutils.NUM_ENTITIES_TO_DELETE_PER_SQL));
			if (deleteStudentParentCount < numberOfRows && CollectionUtils.isNotEmpty(subList)) {
				if (subList.size() < StudentCourseConstantsutils.NUM_ENTITIES_TO_DELETE_PER_SQL) {
					subList = StudentCourseCommonUtils.addElementsToList(subList, StudentCourseConstantsutils.NUM_ENTITIES_TO_DELETE_PER_SQL);
				}
				processedCount += StudentCourseConstantsutils.NUM_ENTITIES_TO_DELETE_PER_SQL;
				deleteStudentParentCount += studentCourseMapper.deleteStudent(subList);
			}
			else {
				done = true;
			}
		}
		LOGGER.debug("Repository: Deleted rows from studentCourseMapper.deleteStudent  {}", deleteStudentParentCount);
		return deleteStudentParentCount;
	}

}
