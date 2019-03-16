package com.example.rest.Service;

import java.util.List;

import com.example.rest.model.StudentCourse;

public interface IstudentCourseService {

	public String InsertStudentCourse(StudentCourse studentCourse);
	public List<StudentCourse> FetchStudentCourse(String semester,String coursename);
	public List<StudentCourse> getAll();
}
