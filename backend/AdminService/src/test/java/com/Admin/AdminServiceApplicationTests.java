package com.Admin;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Admin.Model.AdminModel;
import com.Admin.Service.adminserviceimpl;
import com.Admin.repo.AdminRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceApplicationTests {

	@Autowired
	private adminserviceimpl service;

	@MockBean
	private AdminRepo repository;

	@Test
	public void getAdminsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new AdminModel("Danile","dany123"),
						new AdminModel( "Huy","sfgt123")).collect(Collectors.toList()));
		assertEquals(2, service.findAll().size());
	}

	

	@Test
	public void saveAdminTest() {
		AdminModel admin= new AdminModel("Pranya","pranu345");
		Mockito.when(repository.save(admin)).thenReturn(admin);
	
	}
	



	@Test
	public void deleteAdminTest() {
		AdminModel admin = new AdminModel("Pranya1","pranu345");	
		service.deleteadmin(admin);
		verify(repository, times(1)).delete(admin);
	}

}

