package com.projet.service;

import java.util.List;

import com.projet.model.Region;

public interface IRegionService {
	public List<Region> recupererListeRegions();
	public void removeRegion(long id);
	public void addRegion(long id, String name);
	public void updateRegion(long id, String name);
}
