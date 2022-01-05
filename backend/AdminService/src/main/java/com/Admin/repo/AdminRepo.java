package com.Admin.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Admin.Model.AdminModel;

@Repository
public interface AdminRepo extends MongoRepository<AdminModel, Integer> {


	


}
