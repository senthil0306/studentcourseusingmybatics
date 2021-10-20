package com.student.course.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.course.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
	public Optional<Student> findStudentByStudentName(String studentName);

}
