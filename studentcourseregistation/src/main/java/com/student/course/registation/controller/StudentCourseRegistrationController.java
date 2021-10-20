package com.student.course.registation.controller;

import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.course.model.Course;
import com.student.course.model.Student;
import com.student.course.service.CourseService;
import com.student.course.service.StudentService;



@RestController
public class StudentCourseRegistrationController {
	private final static Logger LOG = LoggerFactory.getLogger(StudentCourseRegistrationController.class);

	private StudentService studentService;
	private CourseService courseService;

	@Autowired
	public StudentCourseRegistrationController(StudentService studentService, CourseService courseService) {
		this.studentService = studentService;
		this.courseService = courseService;
	}

	@PostMapping("/student")
	public String addStudent(@Valid @RequestBody Student student) {
		LOG.info("Student :: Student Name {}", student.getStudentName());
		studentService.addStudent(student);
		return "Student with Name:" + student.getStudentName() + " has been Added.";
	}

	@DeleteMapping("/student/{studentId}")
	public String removeStudent(Long studentId) {
		studentService.removeStudent(studentId);
		return "Student with Id:" + studentId + " has been removed.";
	}

	@PostMapping("/course")
	public String addCourse(@Valid @RequestBody Course course) {
		LOG.info("Course  ::Course Name {}", course.getCourseName());
		courseService.addCourse(course);
		return "Course with Name:" + course.getCourseName() + " has been Added.";
	}

	@DeleteMapping("/course/{courseId}")
	public String removeCourse(Long courseId) {
		courseService.removeCourse(courseId);
		return "Course with Id:" + courseId + " has been removed.";
	}

	@PutMapping("/registerStudentsToCourse/{courseId}")
	public String enrollStudentToCourse(@PathVariable Long courseId, @RequestBody Set<Student> students) {
		courseService.registerStudentToCourse(courseId, students);
		return "Students has been successfully Enrolled to Course :: " + courseId;
	}

	@GetMapping("/studentsByName/{studentName}")
	public Set<Student> getStudentsByName(@PathVariable String studentName) {
		return studentService.getStudentsByName(studentName);
	}

}
