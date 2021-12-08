package com.learning.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

import com.learning.course.dbinterfaces.ICourseService;
import com.learning.course.model.Course;
import com.learning.course.repository.CourseRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseService implements ICourseService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	ReactiveMongoTemplate template;

	@Override
	public Flux<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Mono<Course> findCourseById(Integer id) {
		return courseRepository.findById(id);
	}

	@Override
	public Mono<Course> addOrUpdateCourse(Course course) {
		return courseRepository.save(course);//.subscribe(c -> System.out.println("Result:\t" + c));
	}

	public Flux<Course> findCourseByStudentAge(long age) {
		return courseRepository.findCourseByStudentAge(age);
	}
	
}
