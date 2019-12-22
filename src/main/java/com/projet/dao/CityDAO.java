package com.projet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.City;
import com.projet.model.City;

public class CityDAO implements ICityDAO {

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @Transactional(readOnly=true)
	public List<City> recupererListeVille() {
		Session session = sessionFactory.getCurrentSession();
        List<City> cityList = session.createQuery("from City").setMaxResults(100).list();
        return cityList;
	}
    
    @Transactional(readOnly=false)
   	public void removeCity(long id) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete City c where c.id = :id")
        .setLong("id", id )
        .executeUpdate();
   	}
    
    @Transactional(readOnly=false)
   	public void updateCity(long id, String name, String zipLabel) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("update City c set c.cityName = :name, c.cityZipLabel = :zipLabel where c.id = :id")
        .setLong("id", id )
        .setParameter("name", name)
        .setParameter("zipLabel", zipLabel)
        .executeUpdate();
   	}
    
    
    @Transactional(readOnly=false)
   	public void addCity(long id, String name, String zipLabel) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createSQLQuery("INSERT INTO city (ID, CITY_NAME, ZIP_LABEL) VALUES (:id,:name,:zipLabel)");
       query.setParameter("id", id);
       query.setParameter("name", name);
       query.setParameter("zipLabel", zipLabel);
       query.executeUpdate();
   	}
    
    @Transactional(readOnly=true)
   	public List<City> searchCity(String term) {
   		Session session = sessionFactory.getCurrentSession();
           List<City> CityList = session.createQuery("from City as l where l.cityName like ?").setString(0, "%"+term+"%").setMaxResults(1000).list();
           return CityList;
   	}
       
   @Transactional(readOnly=true)
  	public City getCity(int id) {
  	  Session session = sessionFactory.getCurrentSession();
      City City = (City) session.createQuery("from City as l where l.id = :id").setParameter("id", id).uniqueResult();
      return City;
  	}
    
}


