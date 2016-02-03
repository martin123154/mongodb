package com.example.nosqldemo.domain;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;


public class Przedstawienie {


private ObjectId id;
private String tytul;
private String rezyser; 
private String data_rozp;


public String getTytul() {
	return tytul;
}
public void setTytul(String tytul) {
	this.tytul = tytul;
}
public String getRezyser() {
	return rezyser;
}
public void setRezyser(String rezyser) {
	this.rezyser = rezyser;
}
public ObjectId getId() {
	return id;
}
public void setId(ObjectId id) {
	this.id = id;
}

public String getData_rozp() {
	return data_rozp;
}
public void setData_rozp(String data_rozp) {
	this.data_rozp = data_rozp;
}

}
