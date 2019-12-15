package com.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="area")
public class Region 
{
    @Id
    @Column(name="ID_AREA", nullable=false)
    private int idArea;
    
    @Column(name="AREA_LABEL", nullable=false)
    private String areaLabel;

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getAreaLabel() {
		return areaLabel;
	}

	public void setLabel(String label) {
		this.areaLabel = label;
	}
}