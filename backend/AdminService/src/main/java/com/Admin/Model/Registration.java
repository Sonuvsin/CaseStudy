package com.Admin.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="users")
public class Registration {
	
	 @Transient
	    public static final String SEQUENCE_NAME = "users_sequence";

	
	@Id
	private Long id;
	
	@NotEmpty(message = "Name must not be empty")
	private String Name;
	
	@NotEmpty(message = "Emailid must not be empty")
	private String EmailId;
	
	@NotEmpty(message = "Phone Number must not be empty")
	@Size(max=10,message="10 Digit Mobile Number")
	private Integer Contact;
	
	@NotEmpty(message = "userName must not be empty")
	private String UserName;
	
	@NotEmpty(message = "Rassword Must not be empty")
	@Size(min=8,message="Not Strong Password")
	private String Password;
	
	
	
	public Registration(String name, String emailId, Integer contact, String userName, String password) {
		super();
		this.Name = name;
		EmailId = emailId;
		Contact = contact;
		UserName = userName;
		Password = password;
	
	}


	public Registration() {
		super();
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getEmailId() {
		return EmailId;
	}


	public void setEmailId(String emailId) {
		EmailId = emailId;
	}


	public Integer getContact() {
		return Contact;
	}


	public void setContact(Integer contact) {
		Contact = contact;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	
	}


	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}


	@Override
	public String toString() {
		return "Registration [id=" + id + ", Name=" + Name + ", EmailId=" + EmailId + ", Contact=" + Contact
				+ ", UserName=" + UserName + ", Password=" + Password +  "]";
	}


	
	
	
}