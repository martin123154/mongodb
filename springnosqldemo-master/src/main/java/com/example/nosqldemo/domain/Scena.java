package com.example.nosqldemo.domain;

import java.util.List;

import org.bson.types.ObjectId;

public class Scena {

	private ObjectId id;
	private String nazwa;
	private String wielkosc;
    private List<Przedstawienie> przedstawienia;
	
	public List<Przedstawienie> getPrzedstawienia() {
		return przedstawienia;
	}
	public void setPrzedstawienia(List<Przedstawienie> przedstawienia) {
		this.przedstawienia = przedstawienia;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getWielkosc() {
		return wielkosc;
	}
	public void setWielkosc(String wielkosc) {
		this.wielkosc = wielkosc;
	}
}
