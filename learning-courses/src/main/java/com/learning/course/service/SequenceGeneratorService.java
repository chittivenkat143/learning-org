package com.learning.course.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.learning.course.model.db.DatabaseSequence;

@Service
public class SequenceGeneratorService {
	
	private ReactiveMongoOperations mongoOperations;

	@Autowired
	public SequenceGeneratorService(ReactiveMongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}
	
	public long generateSequence(String seqName) {
		//DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1), options().returnNew(true).upsert(true), DatabaseSequence.class);
		try {
			return mongoOperations.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),  options().returnNew(true).upsert(true), DatabaseSequence.class)
					.toFuture().get().getSeq();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}
