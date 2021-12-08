package com.learning.course.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.learning.course.model.Course;

import reactor.core.publisher.Flux;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, Integer>{
	
	@Query(value = "{ 'students.age': {$gt: ?0} }")
	Flux<Course> findCourseByStudentAge(long age);
}
