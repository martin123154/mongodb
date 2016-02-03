package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Przedstawienie;


public interface PrzedstawienieRepository extends CrudRepository<Przedstawienie, ObjectId> {
	
	List<Przedstawienie> findBytytul(String tytul);
	

	    List<Przedstawienie> findByRezyser(String rezyser);
	  
	    @Query(value = "{ 'tytul' : ^?Tak}" )
		List<Przedstawienie> znajdzPrzedstawienie(); 
	    
	    Przedstawienie findById(ObjectId id);

}
