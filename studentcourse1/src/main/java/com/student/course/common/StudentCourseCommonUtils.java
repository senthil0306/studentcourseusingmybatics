/*
 * Copyright (c) 2021
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.student.course.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Utils class to handle some util methods used across the Application
 * @author Senthil M
 *
 */
public final class StudentCourseCommonUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentCourseCommonUtils.class);
	private StudentCourseCommonUtils() {

	}
	public static List<Double> addElementsToList(List<Double> someOIDs, int numToGet) {
		while (someOIDs.size() < numToGet) {
			someOIDs.add(someOIDs.get(0));
		}
		return someOIDs;
	}

}
