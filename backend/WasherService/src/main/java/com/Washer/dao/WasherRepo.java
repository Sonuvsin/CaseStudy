package com.Washer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.Washer.Model.WasherDetails;

	@Repository
	public interface WasherRepo extends MongoRepository<WasherDetails, Integer>{


}
