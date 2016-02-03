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




@Component
public class ScenaManager {

	@Autowired
	ScenaRepository scenaRepository;
	@Autowired
	PrzedstawienieRepository przedstawienieRepository;
	
	public void addScena(Scena scena){
		scenaRepository.save(scena);
	}
	 public Scena findById(ObjectId id){
	        return scenaRepository.findOne(id);
	    }
	public void deleteScena(Scena scena){
		scenaRepository.delete(scena);
	}

    public List<Przedstawienie> findPrzedstawienieOnScena(Scena scena){
        return scena.getPrzedstawienia();
    }
	
	
	public List<Scena> getSceny(){
		return (List<Scena>) scenaRepository.findAll();
	}
	
	
    public void deletePrzedstawieniefromScenaByTytul(Scena scena, String tytul) {
        List<Przedstawienie> przedstawienieList = findPrzedstawienieOnScena(scena);
        for (int i = 0; i < przedstawienieList.size(); i++) {
            if (przedstawienieList.get(i).getTytul() == tytul) {
                ObjectId id = scena.getPrzedstawienia().get(i).getId();
                scena.getPrzedstawienia().remove(i);
                przedstawienieRepository.delete(id);
                scenaRepository.save(scena);
                i--;
            }
        }
    }
	
}
