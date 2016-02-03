package com.example.nosqldemo.service;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.Przedstawienie;
import com.example.nosqldemo.domain.Scena;
import com.example.nosqldemo.repository.PrzedstawienieRepository;
import com.example.nosqldemo.repository.ScenaRepository;


public class ScenaManager {

	@Autowired
	private  ScenaRepository scenaRepository;
	private  PrzedstawienieRepository przedstawienieRepository;
	
	public void addScena(Scena scena){
		scenaRepository.save(scena);
	}
	public void deleteScena(Scena scena){
		scenaRepository.delete(scena);
	}
	public void deletePrzedstawienie(Przedstawienie przedstawienie){
		przedstawienieRepository.delete(przedstawienie);
	}
	public List<Scena> getSceny(String nazwa){
		return scenaRepository.findByNazwa(nazwa);
	}
	

	
	public List<Scena> getSceny(){
		return (List<Scena>) scenaRepository.findAll();
	}
	
	

	
	public Scena getComputer(ObjectId id){
		return scenaRepository.findById(id);
	}
	
}
