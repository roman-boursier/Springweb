package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.IRegionDAO;
import com.projet.model.Region;

@Service
public class RegionService implements IRegionService {
	
	@Autowired
    private IRegionDAO regionDao;
	
	public IRegionDAO getCountryDao() {
		return regionDao;
	}

	public void setRegionDao(IRegionDAO regionDao) {
		this.regionDao = regionDao;
	}
	
	@Transactional(readOnly=true)
	public List<Region> recupererListeRegions(){
		List<Region> listRegion = regionDao.recupererListeRegions();
		return listRegion;		
	}

	
}


