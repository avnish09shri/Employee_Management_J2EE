package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@GetMapping("/students")
	public String listStudents(Model model)
	{
		model.addAttribute("students", studentservice.getAllStudent());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "add_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		Student student=new Student();
		model.addAttribute("student", studentservice.getStudentId(id));
		return "update_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student, Model model)
	{
		Student existingStudent=studentservice.getStudentId(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		studentservice.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/remove/{id}")
	public String removeStudentForm(@PathVariable Long id) {
		studentservice.deleteStudentById(id);
		return "redirect:/students";
	}
}
