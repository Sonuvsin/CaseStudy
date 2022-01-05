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

import com.Admin.Model.WashPacks;
import com.Admin.repo.WashPackRepo;
import com.Admin.Model.DatabaseSequence;

@Service
public class WashPackServiceimpl implements WashPackService {
	
	@Autowired
	private WashPackRepo packagerepo;

	@Override
	public List<WashPacks> getAll() {
		// TODO Auto-generated method stub
		return  packagerepo.findAll();
	}

	@Override
	public void savewashpack(WashPacks pack) {
		// TODO Auto-generated method stub
		 packagerepo.save(pack);
	}

	@Override
	public void updatewashpack(WashPacks pack) {
		// TODO Auto-generated method stub
		packagerepo.save(pack);
	}

	@Override
	public void deletewashpack(int id) {
		// TODO Auto-generated method stub
		 packagerepo.deleteById(id);
	}
	
	@Autowired
    private  MongoOperations mongoOperations;

	 public long getSequenceNum(String sequenceName) {
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
