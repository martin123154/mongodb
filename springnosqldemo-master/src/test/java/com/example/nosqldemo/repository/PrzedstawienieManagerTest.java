package com.example.nosqldemo.repository;

import static org.junit.Assert.assertEquals;

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







@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class PrzedstawienieManagerTest {

	@Autowired
    PrzedstawienieRepository przedstawienieManager;
	
    private final String tytul1 = "Kosakowo";
    private final String rezyser1 = "Jackson";
    private final String data_rozp1 = "11-10-2013";
    private final String tytul2 = "Zebynowo";
    private final String rezyser2 = "Spielberg";
    private final String data_rozp2 = "11-10-2014";
    private final String tytul3 = "Lew";
    private final String rezyser3 = "Linda";
    private final String data_rozp3 = "11-10-2015";
    
    private final List<ObjectId> wszystkiePrzedstawienia = new ArrayList<ObjectId>();
    
    @Before
    public void checkAdding() {
        List<Przedstawienie> przedstawienieList = przedstawienieManager.findAll();
        for(Przedstawienie p : przedstawienieList) {
        	wszystkiePrzedstawienia.add(p.getId());
        }
    }

    @After
    public void potestach() {
        List<Przedstawienie> przedstawienieList = przedstawienieManager.findAll();

        for (Przedstawienie p : przedstawienieList) {
            if (!wszystkiePrzedstawienia.contains(p.getId())) {
            	przedstawienieManager.delete(p);
            }
        }
    }
    
    @Test
    public void checkAddPrzedstawienie() {
    	
    	 List<Przedstawienie> przedstawienieList = przedstawienieManager.findAll();
    	
    	Przedstawienie przedstawienie = new Przedstawienie();
    	przedstawienie.setTytul(tytul1);
    	przedstawienie.setRezyser(rezyser1);
    	przedstawienie.setData_rozp(data_rozp1);
    	przedstawienieManager.save(przedstawienie);
   	    List<Przedstawienie> przedstawienieList1 = przedstawienieManager.findAll();
   	 
   	 Przedstawienie dodanePrzedstawienie = przedstawienieManager.findOne(przedstawienie.getId());
   	 
   	 assertEquals(przedstawienie.getTytul(), dodanePrzedstawienie.getTytul());
   	 assertEquals(przedstawienie.getRezyser(), dodanePrzedstawienie.getRezyser());
     assertEquals(przedstawienie.getData_rozp(), dodanePrzedstawienie.getData_rozp());
     
     assertEquals(przedstawienieList1.size(), przedstawienieList.size()+1);
     
     Przedstawienie przedstawienie2 = new Przedstawienie();
 	przedstawienie2.setTytul(tytul2);
 	przedstawienie2.setRezyser(rezyser2);
 	przedstawienie2.setData_rozp(data_rozp2);
 	przedstawienieManager.save(przedstawienie2);
	List<Przedstawienie> przedstawienieList2 = przedstawienieManager.findAll();
	    
   	 assertEquals(przedstawienieList2.size(), przedstawienieList.size()+2);
}
    @Test
    public void checkDeletePrzedstawienie () {
    
    	 List<Przedstawienie> przedstawienieList = przedstawienieManager.findAll();
    	 
    	Przedstawienie przedstawienie = new Przedstawienie();
    	przedstawienie.setTytul(tytul3);
    	przedstawienie.setRezyser(rezyser3);
    	przedstawienie.setData_rozp(data_rozp3);
    	przedstawienieManager.save(przedstawienie);
    	
    	 List<Przedstawienie> przedstawienieList1 = przedstawienieManager.findAll();
    	 assertEquals(przedstawienieList.size()+1, przedstawienieList1.size());
    	 
    	 przedstawienieManager.delete(przedstawienie);
    	 List<Przedstawienie> przedstawienieList2 = przedstawienieManager.findAll();
    	 assertEquals(przedstawienieList.size(), przedstawienieList2.size());
    	
    	
    }
    
    @Test
    public void checkEditPrzedstawienie () {
    	
   
   	 
    	Przedstawienie przedstawienie = new Przedstawienie();
    	przedstawienie.setTytul(tytul1);
    	przedstawienie.setRezyser(rezyser1);
    	przedstawienie.setData_rozp(data_rozp1);
    	przedstawienieManager.save(przedstawienie);
    	
    	 List<Przedstawienie> przedstawienieList = przedstawienieManager.findAll();
    	   	przedstawienie.setTytul(tytul3);
        	przedstawienie.setRezyser(rezyser3);
        	przedstawienie.setData_rozp(data_rozp3);
        	przedstawienieManager.save(przedstawienie);

        	 Przedstawienie edytowanePrzedstawienie = przedstawienieManager.findOne(przedstawienie.getId());
        	 assertEquals(edytowanePrzedstawienie.getTytul(), tytul3);
             assertEquals(edytowanePrzedstawienie.getRezyser(), rezyser3);
             assertEquals(edytowanePrzedstawienie.getData_rozp(), data_rozp3);
             
             List<Przedstawienie> przedstawienieList2 = przedstawienieManager.findAll();
        	 assertEquals(przedstawienieList.size(), przedstawienieList2.size());
    }
    	 
        	    @Test
        	    public void checkFindPrzedstawienieByTytul () {
        	   
        	  
        	    	Przedstawienie przedstawienie = new Przedstawienie();
        	    	
        	    	przedstawienie.setTytul(tytul1);
        	    	przedstawienie.setRezyser(rezyser1);
        	    	przedstawienie.setData_rozp(data_rozp1);
        	    	przedstawienieManager.save(przedstawienie);
        	    	

        	    	Przedstawienie przedstawienie2 = new Przedstawienie();
        	    	
        	    	
        	    	
        	    	przedstawienie2.setTytul(tytul2);
        	    	przedstawienie2.setRezyser(rezyser2);
        	    	przedstawienie2.setData_rozp(data_rozp2);
        	    	przedstawienieManager.save(przedstawienie2);
        	    	
        	    	List<Przedstawienie> przedstawienieList = przedstawienieManager.findByTytul(przedstawienie2.getTytul());

        	    	Przedstawienie przedstawienie3 = new Przedstawienie();
        	    	przedstawienie3.setTytul(tytul2);
        	    	przedstawienie3.setRezyser(rezyser3);
        	    	przedstawienie3.setData_rozp(data_rozp3);
        	    	przedstawienieManager.save(przedstawienie3);
        	
        	    	 List<Przedstawienie> przedstawienieList2 = przedstawienieManager.findByTytul(przedstawienie2.getTytul());
        	    	 
        	    	 assertEquals(przedstawienieList.size(), przedstawienieList2.size()-1);
        	    	
    }
    
    
    
}
