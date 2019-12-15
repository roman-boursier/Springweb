package com.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.Country;

public class CountryDAO implements ICountryDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Transactional(readOnly=true)
	public List<Country> recupererListePays() {
		Session session = sessionFactory.getCurrentSession();
        List<Country> countryList = session.createQuery("from Country").list();
        return countryList;
	}
    
}


