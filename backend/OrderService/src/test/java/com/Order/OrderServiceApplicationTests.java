package com.Order;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Order.dao.OrderRepo;
import com.Order.model.OrderDetails;
import com.Order.service.OrderServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceApplicationTests {
	
	@Autowired
	private OrderServiceImpl service;

	@MockBean
	private OrderRepo repository;

	
	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new OrderDetails("233133","Sonu","Maruti","Santro","silver","22","728292","Mumbai"),
						new OrderDetails("11","Sonu","Maruti","Santro","silver","22",728292,"Mumbai")).collect(Collectors.toList()));
		assertEquals(2, service.findAllorders().size());
	}

	
	@Test
	public void saveUserTest() {
		OrderDetails order = new OrderDetails("Maruti","Santro","1","22",728292,"Mumbai");
		when(repository.save(order)).thenReturn(order);
		
	}

	@Test
	public void deleteUserTest() {
		OrderDetails order = new OrderDetails("Maruti","Santro","1","22",728292,"Mumbai");	
		service.cancelorder(order);
		verify(repository, times(1)).delete(order);
	}


	
	
}




