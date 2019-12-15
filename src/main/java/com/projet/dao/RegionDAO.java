package com.projet.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.Region;

public class RegionDAO implements IRegionDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Transactional(readOnly=true)
	public List<Region> recupererListeRegions() {
		Session session = sessionFactory.getCurrentSession();
        List<Region> regionList = session.createQuery("from Region").list();
        return regionList;
	}
    
}


