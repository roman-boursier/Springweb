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
        List<Region> regionList = session.createQuery("from Region r order by r.idArea DESC").list();
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
   	public void addRegion(String name) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createSQLQuery("INSERT INTO area (ID_AREA, AREA_LABEL, ID_COUNTRY, LANGUAGE_ID) VALUES (0, :name, 0, 0)");
       query.setParameter("name", name);
       query.executeUpdate();
   	}
    
    @Transactional(readOnly=true)
	public List<Region> searchRegion(String term) {
		Session session = sessionFactory.getCurrentSession();
        List<Region> RegionList = session.createQuery("from Region as l where l.areaLabel like ?").setString(0, "%"+term+"%").list();
        return RegionList;
	}
    
    @Transactional(readOnly=true)
   	public Region getRegion(int id) {
   	   Session session = sessionFactory.getCurrentSession();
       Region Region = (Region) session.createQuery("from Region as l where l.idArea = :id").setParameter("id", id).uniqueResult();
       return Region;
   	}
    
}


