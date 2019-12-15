package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.ICityDAO;
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



	
}


