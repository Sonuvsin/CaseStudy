package com.Admin.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Admin.Model.WashPacks;


@Repository
public interface WashPackRepo extends MongoRepository<WashPacks, Integer> {



}
