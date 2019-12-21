package com.projet.service;

import java.util.List;

import com.projet.model.City;

public interface ICityService {
	public List<City> recupererListeVille();
	public void removeCity(long id);
	public void addCity(long id, String name, String zipLabel);
	public void updateCity(long id, String name, String zipLabel);
	
}
