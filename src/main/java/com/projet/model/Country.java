package com.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="country")
public class Country 
{
    @Id
    @Column(name="ID_COUNTRY", nullable=false)
    private int idCountry;
    
    @Column(name="CODE_ISO", nullable=false)
    private String codeIso;

	public int getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public String getCodeIso() {
		return codeIso;
	}

	public void setCodeIso(String codeIso) {
		this.codeIso = codeIso;
	}
}