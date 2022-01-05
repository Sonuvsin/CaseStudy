package com.Order;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.Payment.dao.PaymentRepo;
import com.Payment.model.PaymentDetails;
import com.Payment.service.PaymentServiceimpl;




@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentServiceApplicationTests {
	
	

	@Autowired
	private PaymentServiceimpl service;

	@MockBean
	private PaymentRepo repository;

	

	
//	@Test
//	public void saveUserTest() {
//		PaymentDetails payd = new PaymentDetails(1500,"Successfull","15");
//		when(repository.save(payd)).thenReturn(payd);
		
	}




