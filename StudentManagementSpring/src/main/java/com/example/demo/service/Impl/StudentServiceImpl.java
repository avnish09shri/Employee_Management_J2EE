package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentrepo;
	
	public StudentServiceImpl(StudentRepository studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}

	@Override
	public List<Student> getAllStudent(){
		return studentrepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentrepo.save(student);
	}

	@Override
	public Student getStudentId(Long id) {
		return studentrepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentrepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentrepo.deleteById(id);
		
	}
	
	
	
}
