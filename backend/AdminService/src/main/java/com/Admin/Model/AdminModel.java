package com.Admin.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Admindata")
public class AdminModel {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	@Id
	private Long id;
	
	@NotEmpty(message="Name Should not be Empty")
	private String Name;
	@NotEmpty(message="Password Should have all Character with Numbers")
	@Size(min=10,max=20,message="Not Strong password!!")
	private String Password;
	
	public AdminModel( String name, String password) {
		super();
	
		this.Name = name;
		this.Password = password;
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
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "AdminModel [id=" + id + ", Name=" + Name + ", Password=" + Password + "]";
	}
	public AdminModel() {
		super();
	}
	
	
	
}
