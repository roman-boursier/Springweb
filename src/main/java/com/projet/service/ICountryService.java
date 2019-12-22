package com.projet.service;

import java.util.List;

import com.projet.model.Country;

public interface ICountryService {
	public List<Country> recupererListePays();
	public List<Country> searchCountry(String term);
	public Country getCountry(int id);
	public void removeCountry(long id);
	public void addCountry(long id, String code);
	public void updateCountry(long id, String code);
}
