package com.Admin.Model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="ordersdetails")
public class OrderDetails {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	
	@Id
	@NotEmpty(message = "Order Id must not be empty")
	private Long orderId;
	
	@NotEmpty(message = "carName must not be empty")
	private String Name;

	
	@NotEmpty(message = "carName must not be empty")
	private String carName;

	@NotEmpty(message = "car model must not be empty")
	private String carModel;
	

	@NotEmpty(message = "wash pack must not be empty")
	private String washpackName;

	@NotEmpty(message = "date must not be empty")
	private String date;
	
	@NotEmpty(message = "phone no must not be empty")
	private int phoneNo;
	
	
	@NotEmpty(message = "address must not be empty")
	private String Address;


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	
	

	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getCarName() {
		return carName;
	}


	public void setCarName(String carName) {
		this.carName = carName;
	}


	public String getCarModel() {
		return carModel;
	}


	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}




	public String getWashpackName() {
		return washpackName;
	}


	public void setWashpackName(String washpackName) {
		this.washpackName = washpackName;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public OrderDetails(@NotEmpty(message = "Order Id must not be empty") Long orderId,
			@NotEmpty(message = "carName must not be empty") String name,
			@NotEmpty(message = "carName must not be empty") String carName,
			@NotEmpty(message = "car model must not be empty") String carModel,
			@NotEmpty(message = "wash pack must not be empty") String washpackName,
			@NotEmpty(message = "date must not be empty") String date,
			@NotEmpty(message = "phone no must not be empty") int phoneNo,
			@NotEmpty(message = "address must not be empty") String address) {
		super();
		this.orderId = orderId;
		Name = name;
		this.carName = carName;
		this.carModel = carModel;
		this.washpackName = washpackName;
		this.date = date;
		this.phoneNo = phoneNo;
		Address = address;
	}


	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", Name=" + Name + ", carName=" + carName + ", carModel=" + carModel
				+ ", washpackName=" + washpackName + ", date=" + date + ", phoneNo=" + phoneNo + ", Address=" + Address
				+ "]";
	}


	public OrderDetails() {
		super();
	}



}
	