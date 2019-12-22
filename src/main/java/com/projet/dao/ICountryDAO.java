package com.projet.dao;

import java.util.List;
import com.projet.model.Country;

public interface ICountryDAO {

		public List<Country> recupererListePays();
		public List<Country> searchCountry(String term);
		public Country getCountry(int id);
		public void removeCountry(long id);
		public void addCountry(String code);
		public void updateCountry(long id, String code);
}
