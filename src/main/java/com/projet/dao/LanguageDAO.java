package com.projet.dao;

import java.util.List;

import org.hibernate.Query;
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
        List<Language> languageList = session.createQuery("from Language l order by l.idLanguage DESC").list();
        return languageList;
	}
    
    @Transactional(readOnly=false)
   	public void removeLanguage(long id) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete Language l where l.idLanguage = :id")
        .setLong( "id", id )
        .executeUpdate();
   	}
    
    @Transactional(readOnly=false)
   	public void updateLanguage(long id, String code, String name) {
   		Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Language l set l.LanguageName = :name, l.LanguageCode = :code where l.idLanguage = :id")
        .setLong("id", id )
        .setParameter("code", code)
        .setParameter("name", name)
        .executeUpdate();
   	}
    
    
    @Transactional(readOnly=false)
   	public void addLanguage(String code, String name) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createSQLQuery("INSERT INTO language (LANGUAGE_ID, LANGUAGE_CODE, LANGUAGE_NAME) VALUES (0,:code,:name)");
       query.setParameter("code", code);
       query.setParameter("name", name);
       query.executeUpdate();
   	}
    
    @Transactional(readOnly=true)
	public List<Language> searchLangage(String term) {
		Session session = sessionFactory.getCurrentSession();
        List<Language> languageList = session.createQuery("from Language as l where l.LanguageName like ?").setString(0, "%"+term+"%").list();
        return languageList;
	}
    
    @Transactional(readOnly=true)
	public Language getLangage(long id) {
		Session session = sessionFactory.getCurrentSession();
        Language language = (Language) session.createQuery("from Language as l where l.idLanguage = :id").setParameter("id", id).uniqueResult();
        return language;
	}
     
}


