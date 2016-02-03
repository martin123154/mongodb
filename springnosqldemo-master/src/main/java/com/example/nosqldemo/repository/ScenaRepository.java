package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Scena;


public interface ScenaRepository extends CrudRepository<Scena, ObjectId>{
	
	 List<Scena> findAll();
	

}
