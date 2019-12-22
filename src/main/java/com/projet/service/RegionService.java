package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.IRegionDAO;
import com.projet.model.Region;
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
	
	@Transactional(readOnly=false)
	public void updateRegion(long id, String name){
		regionDao.updateRegion(id, name);	
	}
	
	@Transactional(readOnly=false)
	public void removeRegion(long id){
		regionDao.removeRegion(id);	
	}
	
	@Transactional(readOnly=false)
	public void addRegion(long id, String name){
		regionDao.addRegion(id, name);	
	}
	
	@Transactional(readOnly=true)
	public List<Region> searchRegion(String term){
		List<Region> listRegion = regionDao.searchRegion(term);
		return listRegion;		
	}
	
	@Transactional(readOnly=false)
	public Region getRegion(int id){
		Region Region = regionDao.getRegion(id);
		return Region;
	}

}


