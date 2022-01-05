package com.Admin.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="WashPackages")
public class WashPacks {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Id
	private Long id;
	
	private String name;
	private int cost;
	private String description;
	
	@Override
	public String toString() {
		return "WashPacks [id=" + id + ", name=" + name + ", cost=" + cost + ", description=" + description + "]";
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WashPacks( String name, int cost, String description) {
		super();
	
		this.name = name;
		this.cost = cost;
		this.description = description;
	}

	public WashPacks() {
		super();
	}

	
	

}
