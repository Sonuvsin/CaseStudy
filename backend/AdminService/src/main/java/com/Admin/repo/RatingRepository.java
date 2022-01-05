package com.Admin.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Admin.Model.Ratings;

@Repository
public interface RatingRepository extends MongoRepository<Ratings, String> {

	

}