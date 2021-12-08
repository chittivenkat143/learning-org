package com.learning.course.dbinterfaces;

import com.learning.course.model.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICourseService {
	Flux<Course> findAll();
	Mono<Course> findCourseById(Integer id);
	Mono<Course> addOrUpdateCourse(Course course);
}
