package com.WasherService;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Washer.Model.WasherDetails;
import com.Washer.dao.WasherRepo;
import com.Washer.service.WasherDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WasherServiceApplicationTests {

	@Autowired
	private WasherDetailsService service;

	@MockBean
	private WasherRepo repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new WasherDetails("Danile","USA","dany123"),
						new WasherDetails("Huy","UK","sonu123")).collect(Collectors.toList()));
		assertEquals(2, service.getwashers().size());
	}



	@Test
	public void saveUserTest() {
		WasherDetails washer = new WasherDetails("Pranya","Pune","pranu345");
		when(repository.save(washer)).thenReturn(washer);
	
	}

	@Test
	public void deleteUserTest() {
		WasherDetails washer = new WasherDetails("Pranya","Pune","pranu345");	
		service.deletewasher(9999);
		verify(repository, times(1)).delete(washer);
	}

}

