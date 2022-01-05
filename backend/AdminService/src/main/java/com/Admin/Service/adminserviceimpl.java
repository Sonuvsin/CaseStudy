package com.Admin.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.Admin.Model.AdminModel;
import com.Admin.Model.DatabaseSequence;
import com.Admin.repo.AdminRepo;


@Service
public  class adminserviceimpl implements adminservice {
	

    @Autowired
	private AdminRepo repo;

	@Override
	public List<AdminModel> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void save(AdminModel admin) {
		// TODO Auto-generated method stub
		repo.save(admin);
	}

	@Override
	public void updateDetails(AdminModel admin) {
		// TODO Auto-generated method stub
		 repo.save(admin);
	}
	

	@Override
	public void deleteadmin(int id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
	}

	public void deleteadmin(AdminModel admin) {
		// TODO Auto-generated method stub
		repo.delete(admin);
		
	}

	

	@Autowired
    private  MongoOperations mongoOperations;

	 public long getSequenceNumber1(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq", 101);
	        //modify in document
	        DatabaseSequence counter = mongoOperations.findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DatabaseSequence.class);

	        return !Objects.isNull(counter) ? counter.getSeq() : 1;
	    

	 }
}
