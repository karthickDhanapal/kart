package com.example.rest.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.rest.model.StudentCourse;

@Repository
public class StudentCourseRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String student = "insert into Student(id,fname,lname,gpa) values(?,?,?,?)";
	private String course = "insert into Course(courseid,coursename,semester) values(?,?,?)";
	private String studentcourse = "insert into StudentCourse(studentid,courseid) values(?,?)";
	
		public List<StudentCourse> getStudentCourse(String semester,String courseName)
		{
			String query = "select s.id,s.fname,s.lname,c.courseid,c.coursename,s.gpa,c.semester from Student s , StudentCourse sc ,Course c where s.id = sc.studentId and c.courseId=sc.courseid and c.semester=? and c.coursename=?;\n" + 
					"";
			return jdbcTemplate.query(query, new Object[] {semester,courseName},new BeanPropertyRowMapper<>(StudentCourse.class));
		}
		public List<StudentCourse> getAllData()
		{
			String studcourse="select s.id,s.fname,s.lname,s.gpa,c.courseid,c.coursename,c.semester from Student s , StudentCourse sc ,Course c where s.id = sc.studentid and c.courseId=sc.courseid;\n" + 
					"";
		
			List<StudentCourse> result = new ArrayList<StudentCourse>();
			try
			{
				List<Map<String, Object>> rows  =  jdbcTemplate.queryForList(studcourse);
							
				for(Map<String, Object> row:rows){
					StudentCourse student = new StudentCourse();
					student.setId((int)row.get("id"));
					student.setfName((String)row.get("fname"));
					student.setlName((String) row.get("lname"));
					student.setCourseId((int)row.get("courseId"));
					student.setCourseName((String)row.get("coursename"));
					student.setGpa((int)row.get("gpa"));
					student.setSemester((String)row.get("semester"));
					
					
					result.add(student);
				}
			}
			catch(Exception exception)
			{
				System.out.println(exception);
			}
			return  result;
			
		}
		public String InsertData(StudentCourse studentCourse)
		{
			jdbcTemplate.update(student, new Object[] {studentCourse.id,studentCourse.fName,studentCourse.lName,studentCourse.gpa});
			jdbcTemplate.update(course, new Object[] {studentCourse.courseId,studentCourse.courseName,studentCourse.semester});
			jdbcTemplate.update(studentcourse, new Object[] {studentCourse.id,studentCourse.courseId});
			
			return "Success";
		}
}
