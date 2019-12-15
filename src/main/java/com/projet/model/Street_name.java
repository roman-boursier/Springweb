package com.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="street")
public class Street_name 
{
	@Id
	@Column(name="ID")
	int idCity;
	
	
    @Column(name="STREET_NAME_LABEL", nullable=false)
    private String street_name;


	public int getIdCity() {
		return idCity;
	}


	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}


	public String getStreet_name() {
		return street_name;
	}


	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}






}