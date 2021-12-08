package com.learning.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.course.model.Course;
import com.learning.course.model.Student;
import com.learning.course.service.CourseService;
import com.learning.course.service.SequenceGeneratorService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SequenceGeneratorService seqGenerator;
	
	@GetMapping("/all")
	public Flux<Course> getAllCourses(){
		return courseService.findAll();
	}
	
	@GetMapping("/{Id}")
	public Mono<Course> getCourseById(@PathVariable("Id") Integer id){
		return courseService.findCourseById(id);
	}
	
	@PostMapping("/addCourse")
	public Mono<Course> addCourse(@RequestBody Course course) {
		System.out.println("New Course\t" + course.toString());
		//course.setId(seqGenerator.generateSequence(Course.SEQUENCE_NAME));
		//System.out.println("Updated Course Id\t" + course.toString());
		return courseService.addOrUpdateCourse(course);
	}
	

	@GetMapping("/by/{studentAge}")
	public Flux<Course> getStudentsByAge(@PathVariable("studentAge") long age){
		System.out.println("age \t:" + age);
		return courseService.findCourseByStudentAge(age);
	}
}
