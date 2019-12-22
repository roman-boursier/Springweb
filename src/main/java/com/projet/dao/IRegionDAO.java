package com.projet.dao;

import java.util.List;
import com.projet.model.Region;

public interface IRegionDAO {

		public List<Region> recupererListeRegions();
		public void removeRegion(long id);
		public void addRegion(long id, String name);
		public void updateRegion(long id, String name);
		
}
