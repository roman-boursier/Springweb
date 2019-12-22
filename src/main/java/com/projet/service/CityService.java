package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.ICityDAO;
import com.projet.model.City;
import com.projet.model.City;

@Service
public class CityService implements ICityService {
	
	@Autowired
    private ICityDAO cityDao;
	
	public ICityDAO getCityDao() {
		return cityDao;
	}

	public void setCityDao(ICityDAO cityDao) {
		this.cityDao = cityDao;
	}
	
	@Transactional(readOnly=true)
	public List<City> recupererListeVille(){
		List<City> listCity = cityDao.recupererListeVille();
		return listCity;		
	}
	
	@Transactional(readOnly=false)
	public void updateCity(long id, String name, String zipLabel){
		cityDao.updateCity(id, name, zipLabel);	
	}
	
	@Transactional(readOnly=false)
	public void removeCity(long id){
		cityDao.removeCity(id);	
	}
	
	@Transactional(readOnly=false)
	public void addCity(String name, String zipLabel){
		cityDao.addCity(name, zipLabel);	
	}
	
	@Transactional(readOnly=true)
	public List<City> searchCity(String term){
		List<City> listCity = cityDao.searchCity(term);
		return listCity;		
	}
	
	@Transactional(readOnly=false)
	public City getCity(int id){
		City City = cityDao.getCity(id);
		return City;
	}
	
}


