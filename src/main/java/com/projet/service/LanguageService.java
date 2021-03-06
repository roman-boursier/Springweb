package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.dao.ILanguageDAO;
import com.projet.model.Language;

@Service
public class LanguageService implements ILanguageService {
	
	@Autowired
    private ILanguageDAO languageDao;
	
	public ILanguageDAO getLanguageDao() {
		return languageDao;
	}

	public void setLanguageDao(ILanguageDAO languageDao) {
		this.languageDao = languageDao;
	}
	
	@Transactional(readOnly=true)
	public List<Language> recupererListeLangage(){
		List<Language> listLanguage = languageDao.recupererListeLangage();
		return listLanguage;		
	}
	
	@Transactional(readOnly=true)
	public List<Language> searchLangage(String term){
		List<Language> listLanguage = languageDao.searchLangage(term);
		return listLanguage;		
	}
	
	@Transactional(readOnly=false)
	public void updateLanguage(long id, String code, String name){
		languageDao.updateLanguage(id, code, name);	
	}
	
	@Transactional(readOnly=false)
	public void removeLanguage(long id){
		languageDao.removeLanguage(id);	
	}
	
	@Transactional(readOnly=false)
	public void addLanguage(String code, String name){
		languageDao.addLanguage(code, name);	
	}
	
	@Transactional(readOnly=false)
	public Language getLanguage(long id){
		Language language = languageDao.getLangage(id);
		return language;
	}
}


