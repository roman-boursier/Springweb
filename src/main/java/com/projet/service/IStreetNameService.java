package com.projet.service;

import java.util.List;

import com.projet.model.Street_name;

public interface IStreetNameService {
	public List<Street_name> recupererListeRue();
	public void removeListeRue(long id);
	public void addListeRue(long id, String name);
	public void updateListeRue(long id, String name);
}
