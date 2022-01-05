package com.Washer.Controller;

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
import org.springframework.web.client.RestTemplate;

import com.Washer.Model.OrderDetails;
import com.Washer.Model.Ratings;
import com.Washer.Model.WasherDetails;
import com.Washer.service.WasherDetailsServiceImpl;

import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.List;



@CrossOrigin(origins = "http://localhost:3004")
@RestController
@RequestMapping("/washer")
public class WasherController {

@Autowired
private WasherDetailsServiceImpl service;

@Autowired
private RestTemplate restTemplate;



@PostMapping("/addwasher")
@ApiOperation(value = "To Add washer Details")
public String saveUser(@RequestBody WasherDetails washer) {
	washer.setId(service.getSequenceNumber(WasherDetails.SEQUENCE_NAME));
	 service.save(washer);
	 return "you Are working With A1A Carwash";
}

@PutMapping("/account/update")
@ApiOperation(value = "To Update washer Details")
public String updateRegistrationDetails(@RequestBody WasherDetails user, @RequestParam int id) {
	 service.save(user);
	 return "update of details Successfull";

}

@GetMapping("/allwasher")
@ApiOperation(value = "To Get all washer Details")
public List<WasherDetails> findAll(){
	return service.getwashers();
}

@DeleteMapping("/account/delete")
@ApiOperation(value = "To delete washer ")
public String deletewasher( @RequestParam int id ) {
	 this.service.deletewasher(id);
	 return "Account Delete Happy to work With you";
}
	 
	 
@GetMapping("/allratings")
public List<Ratings> getallratings(){
			String baseurl="http://localhost:8081/admin/allratings";
			Ratings[] allratings=restTemplate.getForObject(baseurl, Ratings[].class);
			
			return Arrays.asList(allratings);
		}
		
		@GetMapping("/allorders")
		public List<OrderDetails> getallorders(){
			String baseurl="http://localhost:8085/order/allorders";
			OrderDetails[] allorders=restTemplate.getForObject(baseurl, OrderDetails[].class);
			
			return Arrays.asList(allorders);
		}
	 
	 
}

