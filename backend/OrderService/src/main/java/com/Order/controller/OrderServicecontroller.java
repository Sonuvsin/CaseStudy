package com.Order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Order.model.OrderDetails;
import com.Order.service.OrderServiceImpl;

import io.swagger.annotations.ApiOperation;
import java.util.List;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")
public class OrderServicecontroller {

@Autowired
private OrderServiceImpl service;


@PostMapping("/addorder")
@ApiOperation(value = "To Add order details")
public String addorder(@RequestBody OrderDetails order) {
	order.setOrderId(service.getSequenceNumber(OrderDetails.SEQUENCE_NAME));
	 service.addorder(order);
	 return "Thank You For Choosing us";
	 
}

//@PutMapping("/order/update/{id}")
//@ApiOperation(value = "To Update order Details")
//public void updateorderDetails(@RequestBody OrderDetails order, @PathVariable int id) {
//	 service.updateorderDetails(id,order);

//}

@GetMapping("/allorders")
@ApiOperation(value = "To Get all order Details")
public List<OrderDetails> findAllorder(){
	return service.findAllorders();
}

@DeleteMapping("/cancel")
@ApiOperation(value = "To cancel  order ")
public String cancelorder( @RequestParam int id ) {
	 service.cancelorder(id);
	 
	  return "Sorry And Please let us Know How we can Help you";
}
}

