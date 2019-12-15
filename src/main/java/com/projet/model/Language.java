package com.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="languages")
public class Language 
{
    @Id
    @Column(name="LANGUAGE_ID", nullable=false)
    private long idLanguage;
    
    @Column(name="LANGUAGE_NAME", nullable=false)
    private String LanguageName;

	public long getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(int idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getLanguageName() {
		return LanguageName;
	}

	public void setLanguageName(String languageName) {
		LanguageName = languageName;
	}


}