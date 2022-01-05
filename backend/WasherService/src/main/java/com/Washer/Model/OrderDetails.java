package com.Washer.Model;

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
	private String carName;

	@NotEmpty(message = "car model must not be empty")
	private String carModel;
	

	@NotEmpty(message = "wash pack must not be empty")
	private int washpackId;

	@NotEmpty(message = "date must not be empty")
	private int date;
	
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


	public int getWashpackId() {
		return washpackId;
	}


	public void setWashpackId(int washpackId) {
		this.washpackId = washpackId;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
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


	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", carName=" + carName + ", carModel=" + carModel + ", washpackId="
				+ washpackId + ", date=" + date + ", phoneNo=" + phoneNo + ", Address=" + Address + "]";
	}


	public OrderDetails(String carName, String carModel, int washpackId, int date, int phoneNo,
			String address) {
		super();
		
		this.carName = carName;
		this.carModel = carModel;
		this.washpackId = washpackId;
		this.date = date;
		this.phoneNo = phoneNo;
		this.Address = address;
	}


	public OrderDetails() {
		super();
	}
	
	
	
	
}
	