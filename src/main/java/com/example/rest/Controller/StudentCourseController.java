package com.example.rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.rest.Service.IstudentCourseService;
import com.example.rest.model.StudentCourse;

@Controller
public class StudentCourseController {

	@Autowired
	public IstudentCourseService studentService;
	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage(Model model) {
	return "welcome";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String homePage1(Model model) {
	return "insert";
	}
	 @RequestMapping(value="/form", method=RequestMethod.POST)
	    public ModelAndView customerSubmit(@ModelAttribute StudentCourse student) {
	         
		 studentService.InsertStudentCourse(student);
		 ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("welcome");
	        return modelAndView;
	    }
}
