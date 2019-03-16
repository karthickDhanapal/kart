package com.example.rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.Repository.StudentCourseRepository;
import com.example.rest.model.StudentCourse;

@Service
public class StudentCourseService  implements IstudentCourseService{

	@Autowired
	private StudentCourseRepository studentRepo; 
	@Override
	public String InsertStudentCourse(StudentCourse studentCourse) {
		return studentRepo.InsertData(studentCourse);
		
	}

	@Override
	public List<StudentCourse> FetchStudentCourse(String semester, String coursename) {
		
		return studentRepo.getStudentCourse(semester, coursename);
	}

	@Override
	public List<StudentCourse> getAll() {
		// TODO Auto-generated method stub
		return studentRepo.getAllData();
	}



}
