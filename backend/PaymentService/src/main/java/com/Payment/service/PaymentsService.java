package com.Payment.service;




import java.util.List;


import com.Payment.model.PaymentDetails;



public interface PaymentsService {
	
	public List<PaymentDetails> findAllpayment();

	public void addpayment(PaymentDetails payment);
  
}

	
	