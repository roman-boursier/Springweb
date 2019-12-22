package com.projet.dao;

import java.util.List;

import com.projet.model.Region;

public interface IRegionDAO {

		public List<Region> recupererListeRegions();
		public List<Region> searchRegion(String term);
		public Region getRegion(int id);
		public void removeRegion(long id);
		public void addRegion(String name);
		public void updateRegion(long id, String name);
		
}
