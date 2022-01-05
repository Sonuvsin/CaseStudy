package com.Admin.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
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

import com.Admin.Model.AdminModel;
import com.Admin.Model.JwtRequest;
import com.Admin.Model.JwtResponse;
import com.Admin.Model.OrderDetails;
import com.Admin.Model.PaymentDetails;
import com.Admin.Model.Ratings;
import com.Admin.Model.Registration;
import com.Admin.Model.WashPacks;
import com.Admin.Model.WasherDetails;
//import com.Admin.Service.UserService;
import com.Admin.Service.WashPackServiceimpl;

import com.Admin.Service.adminserviceimpl;
import com.Admin.repo.RatingRepository;
//import com.Admin.util.JWTUtility;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private adminserviceimpl service;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//    private JWTUtility jwtUtility;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private UserService userService;
//	
	
//	@PostMapping("/authenticate")
//    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            jwtRequest.getUsername(),
//                            jwtRequest.getPassword()
//                    )
//            );
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//
//        final UserDetails userDetails
//                = userService.loadUserByUsername(jwtRequest.getUsername());
//
//        final String token =
//                jwtUtility.generateToken(userDetails);
//
//        return  new JwtResponse(token);
//    }

	
	@PostMapping("/addadmin")
	@ApiOperation(value = "To Add admin Details")
	public String saveAdmin(@RequestBody AdminModel admin) {
		admin.setId(service.getSequenceNumber1(AdminModel.SEQUENCE_NAME));
		 service.save(admin);  //user will save his details 
		 return "Registered Succesfull!!!";
	}

	@PutMapping("/account/update")
	@ApiOperation(value = "To update admin Details")
	public String updateDetails(@RequestBody AdminModel admin,@RequestParam int id ) {
		service.updateDetails(admin);
		return "Updated Succesfull!!!";

	}

	@GetMapping("/alladmins")
	@ApiOperation(value = "To Get all User Details")
	public List<AdminModel> findAll() {
	return service.findAll();
		
	}

	@DeleteMapping("/account/delete")
	@ApiOperation(value = "To delete admin Details")
	public String deleteadmin(@RequestBody AdminModel admin,@RequestParam int id ) {
	 service.deleteadmin(id);
	 return "Deleted Succesfull!!!";

	}
	
	
	
	//////
	
	@Autowired
	private WashPackServiceimpl packageservice;
	
	
	@PostMapping("/addwashpack")
	@ApiOperation(value = "To Add washpack Details")
	public String savewashpack(@RequestBody WashPacks packs) {
		packs.setId(packageservice.getSequenceNum(WashPacks.SEQUENCE_NAME));
		 packageservice.savewashpack(packs);
		 return "WashPack Added Succesfully!!!";
	}

	@PutMapping("/washpack/update")
	@ApiOperation(value = "To update washpack Details")
	public String updatewashpackdetails(@RequestBody WashPacks admin,@RequestParam int id ) {
		packageservice.updatewashpack(admin);
		return "Registered Succesfull!!!";

	}

	@GetMapping("/washpack")
	@ApiOperation(value = "To get washpack Details")
	public List<WashPacks> findAll1(){
		return packageservice.getAll();

}
	@DeleteMapping("/washpack/delete")
	@ApiOperation(value = "To delete washpack Details")
	public String deletewashpack(@RequestBody WashPacks admin,@RequestParam int id ) {
	 packageservice.deletewashpack(id);
	 return "Washpack Deleted Succesfully!!!";

	}
	
	
	
	////
	@Autowired
	private RatingRepository repo2;
	
	
	@PostMapping("/addrating")
	public String saverating(@RequestBody Ratings rating)
	{
		repo2.save(rating);
		return " Thanks for Your Valuable feedback";
	}
	@GetMapping("/allratings")
	public List<Ratings> getuser()
	{
		return repo2.findAll();
		
	}
	
	////////rest Template////////
	
	@GetMapping("/allorder")
	public List<OrderDetails> getwashpacks(){
		 String baseurl="http://localhost:8085/order/allorder";
		 OrderDetails[] orders=restTemplate.getForObject(baseurl, OrderDetails[].class);
		return Arrays.asList(orders);
		
	}
	
		
		@GetMapping("/allpayment")
		public List<PaymentDetails> getallpayment(){
			 String baseurl="http://localhost:8086/payment/allpayment";
			 PaymentDetails[] pay=restTemplate.getForObject(baseurl, PaymentDetails[].class);
			return Arrays.asList(pay);
		}
		
			
			@GetMapping("/allusers")
			public List<Registration> getallusers(){
				 String baseurl="http://localhost:8080/user/allusers";
				 Registration[] user =restTemplate.getForObject(baseurl, Registration[].class);
				return Arrays.asList(user);
			
		
}
			@GetMapping("/allwasher")
			public List<WasherDetails> getwasher(){
				 String baseurl="http://localhost:8084/washer/allwasher";
				 WasherDetails[] washer =restTemplate.getForObject(baseurl, WasherDetails[].class);
				return Arrays.asList(washer);
			
			
			}
}
