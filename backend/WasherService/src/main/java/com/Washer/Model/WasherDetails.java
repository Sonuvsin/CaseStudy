package com.Washer.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="washerinfo")
public class WasherDetails {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    public static String getSequenceName() {
		return SEQUENCE_NAME; }
		
	@Id
	private Long id;
	private String name;
	private String location;
	private String password;
	
	
public WasherDetails() {
		super();
	}
public WasherDetails( String name, String location, String password) {
		super();
	
		this.name = name;
		this.location = location;
		this.password = password;
	}
@Override
	public String toString() {
		return "WasherDetails [id=" + id + ", name=" + name + ", location=" + location + ", password=" + password + "]";
	}
public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




}
