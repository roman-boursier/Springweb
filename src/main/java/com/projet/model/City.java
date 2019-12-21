package com.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="city")
public class City 
{
	@Id
	@Column(name="ID")
	int id;
	
	
    @Column(name="CITY_NAME", nullable=false)
    private String cityName;
    
    @Column(name="ZIP_LABEL", nullable=false)
    private String cityZipLabel;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCityName() {
		return cityName;
	}

	public String getCityZipLabel() {
		return cityZipLabel;
	}


	public void setIdCityName(String idCityName) {
		this.cityName = idCityName;
	}
    
  


}