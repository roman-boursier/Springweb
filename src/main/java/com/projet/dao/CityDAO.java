package com.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.City;

public class CityDAO implements ICityDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Transactional(readOnly=true)
	public List<City> recupererListeVille() {
		Session session = sessionFactory.getCurrentSession();
        List<City> cityList = session.createQuery("from City").list();
        return cityList;
	}
    
}


