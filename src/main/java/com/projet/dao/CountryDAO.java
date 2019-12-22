package com.projet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.projet.model.Country;
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
    
    @Transactional(readOnly=false)
   	public void removeCountry(long id) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete Country c where c.idCountry = :id")
        .setLong( "id", id )
        .executeUpdate();
   	}
    
    @Transactional(readOnly=false)
   	public void updateCountry(long id, String code) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Country c set c.codeIso = :code where c.idCountry = :id")
        .setLong("id", id )
        .setParameter("code", code)
        .executeUpdate();
   	}
    
    
    @Transactional(readOnly=false)
   	public void addCountry(long id, String code) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createSQLQuery("INSERT INTO country (ID_COUNTRY, CODE_ISO, MANAGED) VALUES (:id,:code,0)");
       query.setParameter("id", id);
       query.setParameter("code", code);
       query.executeUpdate();
   	}
    
    @Transactional(readOnly=true)
	public List<Country> searchCountry(String term) {
		Session session = sessionFactory.getCurrentSession();
        List<Country> CountryList = session.createQuery("from Country as l where l.codeIso like ?").setString(0, "%"+term+"%").list();
        return CountryList;
	}
    
    @Transactional(readOnly=true)
   	public Country getCountry(int id) {
   	   Session session = sessionFactory.getCurrentSession();
       Country Country = (Country) session.createQuery("from Country as l where l.idCountry = :id").setParameter("id", id).uniqueResult();
       return Country;
   	}
}


