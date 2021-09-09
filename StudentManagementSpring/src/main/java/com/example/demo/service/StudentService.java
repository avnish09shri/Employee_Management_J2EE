package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	List<Student> getAllStudent();
	Student saveStudent(Student student);
	Student getStudentId(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}
