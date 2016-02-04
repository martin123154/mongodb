package com.example.nosqldemo.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.nosqldemo.domain.Przedstawienie;
import com.example.nosqldemo.domain.Scena;
import com.example.nosqldemo.service.PrzedstawienieManager;
import com.example.nosqldemo.service.ScenaManager;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class ScenaManagerTest {
	
	@Autowired
	ScenaManager scenaManager;
	@Autowired
	PrzedstawienieRepository przedstawienieManager;
	
	 private final String nazwa1 = "Czarna";
	    private final String wielkosc1 = "Mała";
	    private final String nazwa2 = "Czerwona";
	    private final String wielkosc2 = "Duża";
	    private final String nazwa3 = "Zielona";
	    private final String wielkosc3 = "Wielka";
	    

	    private final String tytul1 = "Kosakowo";
	    private final String rezyser1 = "Jackson";
	    private final String data_rozp1 = "11-10-2013";
	    private final String tytul2 = "Zebynowo";
	    private final String rezyser2 = "Spielberg";
	    private final String data_rozp2 = "11-10-2014";
	    private final String tytul3 = "Lew";
	    private final String rezyser3 = "Linda";
	    private final String data_rozp3 = "11-10-2015";
	
   
	    
	    @Test
	    public void checkAddScena(){
	    	Scena scena = new Scena();
	    	scena.setNazwa(nazwa1);
	    	scena.setWielkosc(wielkosc1);
	    	
	    	Przedstawienie przedstawienie1 = new Przedstawienie();
	    	przedstawienie1.setTytul(tytul1);
	    	przedstawienie1.setRezyser(rezyser1);
	    	przedstawienie1.setData_rozp(data_rozp1);
	    	przedstawienieManager.save(przedstawienie1);
	    	
	    	Przedstawienie przedstawienie2 = new Przedstawienie();
	    	przedstawienie2.setTytul(tytul2);
	    	przedstawienie2.setRezyser(rezyser2);
	    	przedstawienie2.setData_rozp(data_rozp2);
	    	przedstawienieManager.save(przedstawienie2);
	    	
	    	List<Przedstawienie> przedstawienieList = new ArrayList<Przedstawienie>();
	    	przedstawienieList.add(przedstawienie1);
	    	przedstawienieList.add(przedstawienie2);
	    	scena.setPrzedstawienia(przedstawienieList);
	    		
	    	 List<Scena> scenaList = scenaManager.getSceny();
	         scenaManager.addScena(scena);
	         List<Scena> scenaList1 = scenaManager.getSceny();
	         assertEquals(scenaList1.size(), scenaList.size()+1);
	         
	         Scena scena1 = scenaManager.findById(scena.getId());
	         
	         assertEquals(scena.getNazwa(), scena1.getNazwa());
	         assertEquals(scena.getWielkosc(), scena1.getWielkosc());
	         assertEquals(scenaManager.findPrzedstawienieOnScena(scena1).size(),2);
	    	}
	    
	    @Test
	    public void deletePrzedstawieniefromScena () {
	    	   List<Przedstawienie> przedstawienieList5 = przedstawienieManager.findAll();
	    	Scena scena = new Scena();
	    	scena.setNazwa(nazwa1);
	    	scena.setWielkosc(wielkosc1);
	    	
	    	Przedstawienie przedstawienie = new Przedstawienie();
	    	przedstawienie.setTytul(tytul1);
	    	przedstawienie.setRezyser(rezyser1);
	    	przedstawienie.setData_rozp(data_rozp1);
	    	przedstawienieManager.save(przedstawienie);
	    	
	    	Przedstawienie przedstawienie1 = new Przedstawienie();
	    	przedstawienie1.setTytul(tytul2);
	    	przedstawienie1.setRezyser(rezyser2);
	    	przedstawienie1.setData_rozp(data_rozp2);
	    	przedstawienieManager.save(przedstawienie1);
	    	
	    	Przedstawienie przedstawienie2 = new Przedstawienie();
	    	przedstawienie2.setTytul(tytul2);
	    	przedstawienie2.setRezyser(rezyser3);
	    	przedstawienie2.setData_rozp(data_rozp3);
	    	przedstawienieManager.save(przedstawienie2);
	    	
	    	   List<Przedstawienie> przedstawienieList6 = przedstawienieManager.findAll();
	    	   assertEquals(przedstawienieList6.size()-3, przedstawienieList5.size());
	    	
	    	 List<Przedstawienie> przedstawienieList = new ArrayList<Przedstawienie>();
	    	 
	    	 przedstawienieList.add(przedstawienie);
	    	 przedstawienieList.add(przedstawienie1);
	    	 przedstawienieList.add(przedstawienie2);
	    	 scena.setPrzedstawienia(przedstawienieList);
	    	 
	    	 scenaManager.addScena(scena);
	    	 List<Przedstawienie> przedstawienieList2 = scenaManager.findPrzedstawienieOnScena(scena);
	    	 assertEquals(przedstawienieList2.size(),3);
	    	 scenaManager.deletePrzedstawieniefromScenaByTytul(scena, tytul2);
	    	 
	    	 List<Przedstawienie> przedstawienieList1 = scenaManager.findPrzedstawienieOnScena(scena);
	    	 
	    	 Przedstawienie nieusuniety = przedstawienieManager.findOne(przedstawienie.getId());
	         Przedstawienie usuniety = przedstawienieManager.findOne(przedstawienie1.getId());
	         Przedstawienie usuniety1 = przedstawienieManager.findOne(przedstawienie2.getId());


	         assertNotNull(nieusuniety);
	         assertNull(usuniety);
	         assertNull(usuniety1);
	         assertEquals(przedstawienieList1.size(),1);
	    }
	    }
	    
	    
	    
