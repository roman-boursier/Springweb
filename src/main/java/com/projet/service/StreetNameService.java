package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.IStreetNameDAO;
import com.projet.model.Street_name;

@Service
public class StreetNameService implements IStreetNameService {
	
	@Autowired
    private IStreetNameDAO streetNameDao;
	
	public IStreetNameDAO getStreetNameDao() {
		return streetNameDao;
	}

	public void setStreetNameDao(IStreetNameDAO streetNameDao) {
		this.streetNameDao = streetNameDao;
	}
	
	@Transactional(readOnly=true)
	public List<Street_name> recupererListeRue(){
		List<Street_name> listStreet = streetNameDao.recupererListeRue();
		return listStreet;		
	}
	
	@Transactional(readOnly=false)
	public void updateListeRue(long id, String name){
		streetNameDao.updateListeRue(id, name);	
	}
	
	@Transactional(readOnly=false)
	public void removeListeRue(long id){
		streetNameDao.removeListeRue(id);	
	}
	
	@Transactional(readOnly=false)
	public void addListeRue(String name){
		streetNameDao.addListeRue(name);	
	}
	
	@Transactional(readOnly=true)
	public List<Street_name> searchListeRue(String term){
		List<Street_name> listListeRue = streetNameDao.searchListeRue(term);
		return listListeRue;		
	}
	
	@Transactional(readOnly=false)
	public Street_name getListeRue(int id){
		Street_name ListeRue = streetNameDao.getListeRue(id);
		return ListeRue;
	}

}


