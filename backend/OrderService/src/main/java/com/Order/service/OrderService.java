package com.Order.service;

import java.util.List;

import com.Order.model.OrderDetails;



public interface OrderService{
	
	
	public List<OrderDetails> findAllorders();

	public void addorder(OrderDetails user);

	public void updateorderDetails(int id, OrderDetails user);
		
	public void cancelorder(int id);
}