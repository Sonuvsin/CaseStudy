package com.Washer.service;

import java.util.List;

import com.Washer.Model.WasherDetails;


public interface WasherDetailsService{
	
	


	public void save(WasherDetails user);

	public void updateWasherDetails(int id, WasherDetails user);

	public List<WasherDetails> getwashers();

	void deletewasher(int id);

}