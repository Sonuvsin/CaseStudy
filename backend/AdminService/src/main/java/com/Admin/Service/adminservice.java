package com.Admin.Service;

import java.util.List;

import com.Admin.Model.AdminModel;



public interface adminservice {

	public List<AdminModel> findAll();

	public void save(AdminModel packs);

	public void updateDetails(AdminModel admin);
	
	public void deleteadmin(int id);
}
