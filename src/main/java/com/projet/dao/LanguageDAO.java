package com.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.Language;

public class LanguageDAO implements ILanguageDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Transactional(readOnly=true)
	public List<Language> recupererListeLangage() {
		Session session = sessionFactory.getCurrentSession();
        List<Language> languageList = session.createQuery("from Language").list();
        return languageList;
	}
    
    @Transactional(readOnly=true)
   	public Language recupererSingleLangage() {
   		Session session = sessionFactory.getCurrentSession();
        Language language = (Language) session.createQuery("from Language where LANGUAGE_ID='2'").list();
        return language;
   	}
    
}


