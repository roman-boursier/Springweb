package com.projet.dao;

import java.util.List;
import com.projet.model.City;

public interface ICityDAO {
	public List<City> recupererListeVille();
	public List<City> searchCity(String term);
	public City getCity(int id);
	public void removeCity(long id);
	public void addCity(long id, String name, String zipLabel);
	public void updateCity(long id, String name, String zipLabel);	
}
