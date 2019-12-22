package com.projet.service;

import java.util.List;

import com.projet.model.Street_name;

public interface IStreetNameService {
	public List<Street_name> recupererListeRue();
	public List<Street_name> searchListeRue(String term);
	public Street_name getListeRue(int id);
	public void removeListeRue(long id);
	public void addListeRue(String name);
	public void updateListeRue(long id, String name);
}
