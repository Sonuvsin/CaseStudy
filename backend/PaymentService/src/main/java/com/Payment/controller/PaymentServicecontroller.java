package com.Payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Payment.model.PaymentDetails;
import com.Payment.service.PaymentServiceimpl;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/payment")
public class PaymentServicecontroller {

@Autowired
private PaymentServiceimpl service;

@PostMapping("/addpayment")
@ApiOperation(value = "To Add payment details")
public String addpayment(@RequestBody PaymentDetails payment) {
	 service.addpayment(payment);
	 return "Thank You For Choosing us";
	 
}

@GetMapping("/allpayment")
@ApiOperation(value = "To Get all Payment Details")
public List<PaymentDetails> findAllpayment(){
	return service.findAllpayment();
}
}

