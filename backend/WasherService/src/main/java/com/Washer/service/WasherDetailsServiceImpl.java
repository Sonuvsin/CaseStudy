package com.Washer.service;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.Washer.Model.DatabaseSequence;
import com.Washer.Model.WasherDetails;
import com.Washer.dao.WasherRepo;

@Service
public class WasherDetailsServiceImpl implements WasherDetailsService {
	
	
	@Autowired
	private WasherRepo repo1;



	@Override
	public void save(WasherDetails washer) {
		// TODO Auto-generated method stub
		repo1.save(washer);
		
	}

	@Override
	public void updateWasherDetails(int id, WasherDetails washer) {
		// TODO Auto-generated method stub
		repo1.save(washer);
		
	}

	@Override
	public void deletewasher(int id) {
		// TODO Auto-generated method stub
		 repo1.deleteById(id);
		
	}

	@Override
	public List<WasherDetails> getwashers() {
		// TODO Auto-generated method stub
		return repo1.findAll();
	
	}
	@Autowired
    private  MongoOperations mongoOperations;

	 public long getSequenceNumber(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq", 1);
	        //modify in document
	        DatabaseSequence counter = mongoOperations.findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DatabaseSequence.class);

	        return !Objects.isNull(counter) ? counter.getSeq() : 1;
	    

	 }


		
	}
	
	

