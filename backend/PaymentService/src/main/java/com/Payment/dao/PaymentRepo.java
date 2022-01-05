package com.Payment.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.Payment.model.PaymentDetails;

	@Repository
	public interface PaymentRepo extends MongoRepository<PaymentDetails, Integer>{


}
