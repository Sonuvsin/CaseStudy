package com.Payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Payment.dao.PaymentRepo;
import com.Payment.model.PaymentDetails;

@Service
public class PaymentServiceimpl  implements PaymentsService {
	
	@Autowired
	private PaymentRepo repository;

	@Override
	public List<PaymentDetails> findAllpayment() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void addpayment(PaymentDetails payment) {
		// TODO Auto-generated method stub
		repository.save(payment);
		
	}
	
	

	}

