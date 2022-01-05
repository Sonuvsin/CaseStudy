package com.Admin.Service;

import java.util.List;


import com.Admin.Model.WashPacks;

public interface WashPackService {
	
	public List<WashPacks> getAll();

	public void savewashpack(WashPacks pack);

	public void updatewashpack(WashPacks pack);
	
	public void deletewashpack(int id);

}
