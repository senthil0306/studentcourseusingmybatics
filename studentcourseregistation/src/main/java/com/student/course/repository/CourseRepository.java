package com.student.course.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	public Optional<Course> findCourseByCourseName(String courseName);
}
