package com.projet.dao;

import java.util.List;

import org.hibernate.Query;
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
    
    @Transactional(readOnly=false)
   	public void removeRegion(long id) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete Region r where r.idArea = :id")
        .setLong( "id", id )
        .executeUpdate();
   	}
    
    @Transactional(readOnly=false)
   	public void updateRegion(long id, String name) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Region r set r.areaLabel = :name where r.idArea = :id")
        .setLong("id", id )
        .setParameter("name", name)
        .executeUpdate();
   	}
    
    
    @Transactional(readOnly=false)
   	public void addRegion(long id, String name) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createSQLQuery("INSERT INTO area (ID_AREA, AREA_LABEL, ID_COUNTRY, LANGUAGE_ID) VALUES (:id, :name, 0, 0)");
       query.setParameter("id", id);
       query.setParameter("name", name);
       query.executeUpdate();
   	}
    
}


