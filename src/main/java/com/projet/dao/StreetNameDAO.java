package com.projet.dao;

import java.util.List;

import org.hibernate.Query;
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
	
	@Transactional(readOnly=false)
   	public void removeListeRue(long id) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete Street_name r where r.id = :id")
        .setLong( "id", id )
        .executeUpdate();
   	}
    
    @Transactional(readOnly=false)
   	public void updateListeRue(long id, String name) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Street_name r set r.street_name = :name where r.id = :id")
        .setLong("id", id )
        .setParameter("name", name)
        .executeUpdate();
   	}
    
    
    @Transactional(readOnly=false)
   	public void addListeRue(long id, String name) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createSQLQuery("INSERT INTO street_name (ID, STREET_NAME_LABEL) VALUES (:id, :name)");
       query.setParameter("id", id);
       query.setParameter("name", name);
       query.executeUpdate();
   	}
    
}


