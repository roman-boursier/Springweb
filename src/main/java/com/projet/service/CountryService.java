package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.ICountryDAO;
import com.projet.model.Country;

@Service
public class CountryService implements ICountryService {
	
	@Autowired
    private ICountryDAO countryDao;
	
	public ICountryDAO getCountryDao() {
		return countryDao;
	}

	public void setCountryDao(ICountryDAO countryDao) {
		this.countryDao = countryDao;
	}
	
	@Transactional(readOnly=true)
	public List<Country> recupererListePays(){
		List<Country> listCountry = countryDao.recupererListePays();
		return listCountry;		
	}

	
}


