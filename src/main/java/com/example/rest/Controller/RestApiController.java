package com.example.rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.Service.IstudentCourseService;
import com.google.gson.Gson;


@RestController	
@RequestMapping("/api/studentCourse")
public class RestApiController {
	@Autowired
	public IstudentCourseService studentService;
	
	@PostMapping(value = "/all")
	
	public String getAllStudent() {
	
		return new Gson().toJson(studentService.getAll());
	}
 
	@PostMapping(value = "/search")
	public String searchStudent(@RequestParam("semester") String  semester,@RequestParam("courseName") String coursename) {
		
		// Create Response Object
	
		return new Gson().toJson(studentService.FetchStudentCourse(semester, coursename));
	}

}
