package com.Order.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Order.model.OrderDetails;

	@Repository
	public interface OrderRepo extends MongoRepository<OrderDetails , Integer>{


}
