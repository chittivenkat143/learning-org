package com.learning.course.model.db.events;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.learning.course.model.Course;
import com.learning.course.service.SequenceGeneratorService;

@Component
public class CourseModelListener extends AbstractMongoEventListener<Course>{
	private SequenceGeneratorService sequenceGeneratorService;

	public CourseModelListener(SequenceGeneratorService sequenceGeneratorService) {
		this.sequenceGeneratorService = sequenceGeneratorService;
	}
	
	@Override
	public void onBeforeConvert(BeforeConvertEvent<Course> event) {
		if(event.getSource().getId() < 1) {
			event.getSource().setId(sequenceGeneratorService.generateSequence(Course.SEQUENCE_NAME));
		}
	}
	
}
