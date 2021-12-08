package com.learning.course.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Courses")
public class Course {
	
	@Transient
	public static final String SEQUENCE_NAME = "courses_sequence";
	
	@Id
	private long id;
	private String courseName;
	private String courseTutor;
	private String courseTime;
	private double courseFee;
	
	private List<Student> students;
	
	public Course() {
		super();
	}

	public Course(long id,String courseName, String courseTutor, String courseTime, double courseFee) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseTutor = courseTutor;
		this.courseTime = courseTime;
		this.courseFee = courseFee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTutor() {
		return courseTutor;
	}

	public void setCourseTutor(String courseTutor) {
		this.courseTutor = courseTutor;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseTutor=" + courseTutor + ", courseTime="
				+ courseTime + ", courseFee=" + courseFee + "]";
	}
	
}
