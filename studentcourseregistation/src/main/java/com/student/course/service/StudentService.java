package com.student.course.service;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.course.exception.StudentCourseIllegalStateException;
import com.student.course.model.Course;
import com.student.course.model.Student;
import com.student.course.repository.StudentRepository;


@Service
public class StudentService {
	private final static Logger LOG = LoggerFactory.getLogger(StudentService.class);

	private StudentRepository studentRepository;
	private CourseService courseService;

	@Autowired
	public StudentService(CourseService courseService, StudentRepository studentRepository) {
		this.courseService = courseService;
		this.studentRepository = studentRepository;
	}

	public Long addStudent(Student student) {
		student = studentRepository.save(student);
		LOG.info("Student {} Successfully added", student.getStudentId());
		return student.getStudentId();
	}

	public void removeStudent(Long studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		if (!student.isPresent()) {
			throw new StudentCourseIllegalStateException("Failed to remove Student. Invalid StudentId :: " + studentId);
		}
		studentRepository.delete(student.get());
	}

	public void registerCourse(Long studentId, Set<Course> courses) {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		if (!studentOptional.isPresent()) {
			throw new StudentCourseIllegalStateException("Failed to register course. Invalid CourseId :: " + studentId);
		}
		Student student = studentOptional.get();
		courses.addAll(student.getCourses());
		student.setCourses(courses);
		studentRepository.save(student);
	}

	public Set<Student> getStudentsByName(String studentName) {
		Optional<Student> student = getStudentByName(studentName);
		if (!student.isPresent()) {
			throw new StudentCourseIllegalStateException("Failed to get Students. Invalid StudentName :: " + studentName);
		}
		Comparator<Student> studentByName = (Student student1, Student student2) -> student1.getStudentName()
				.compareTo(student2.getStudentName());
		TreeSet<Student> sortedStudents = new TreeSet<>(studentByName);
		LOG.debug("Actual Students :: {} and Sorted Students by Name:: {}", student, sortedStudents);
		return sortedStudents;
	}
	
	public Optional<Student> getStudentByName(String studentName) {
		return studentRepository.findStudentByStudentName(studentName);
	}

}
