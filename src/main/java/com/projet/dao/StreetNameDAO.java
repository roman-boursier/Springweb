package com.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.Street_name;

public class StreetNameDAO implements IStreetNameDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Transactional(readOnly=true)
	public List<Street_name> recupererListeRue() {
		Session session = sessionFactory.getCurrentSession();
        List<Street_name> Ruelist = session.createQuery("from Street_name").list();
        return Ruelist;
	}
    
}


