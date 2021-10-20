package com.student.course.controller;

import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.student.course.model.Course;
import com.student.course.model.Student;
import com.student.course.registation.controller.StudentCourseRegistrationController;
import com.student.course.service.CourseService;
import com.student.course.service.StudentService;


public class StudentCourseRegistrationControllerTest {
	private final static Logger LOG = LoggerFactory.getLogger(StudentCourseRegistrationController.class);

	@Mock
	private StudentService studentServiceMock;
	@Mock
	private CourseService courseServiceMock;

	@InjectMocks
	private StudentCourseRegistrationController studentCourseRegistrationController;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setStudentId(1l);
		studentCourseRegistrationController.addStudent(student);
	}

	@Test
	public void testRemoveStudent() {
		Long studentId = 1l;
		studentCourseRegistrationController.removeStudent(studentId);
	}

	@Test
	public void testAddCourse() {
		Course course = new Course();
		course.setCourseId(1l);
		LOG.info("Course  ::Course Name {}", course.getCourseName());
		studentCourseRegistrationController.addCourse(course);
	}

	@Test
	public void testRemoveCourse() {
		Long courseId = 1l;
		studentCourseRegistrationController.removeCourse(courseId);
	}

	@Test
	public void testEnrollStudentToCourse() {
		Long courseId = 1l;
		Set<Student> students = Collections.emptySet();
		studentCourseRegistrationController.enrollStudentToCourse(courseId, students);
	}

	@Test
	public void testGetStudentsByStudentName() {
		String courseName = "DevOps";
		studentCourseRegistrationController.getStudentsByName(courseName);
	}

}
