package com.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="language")
public class Language 
{
    @Id
    @Column(name="LANGUAGE_ID", nullable=false)
    private long idLanguage;
    
    @Column(name="LANGUAGE_CODE", nullable=false)
    private String LanguageCode;
    
    @Column(name="LANGUAGE_NAME", nullable=false)
    private String LanguageName;

	public long getIdLanguage() {
		return idLanguage;
	}
	
	public String getLanguageCode() {
		return LanguageCode;
	}
	
	public String getLanguageName() {
		return LanguageName;
	}


	public void setIdLanguage(int idLanguage) {
		this.idLanguage = idLanguage;
	}
	
	public void setLanguageCode(String LanguageCode) {
		this.LanguageCode = LanguageCode;
	}

	public void setLanguageName(String languageName) {
		LanguageName = languageName;
	}


}