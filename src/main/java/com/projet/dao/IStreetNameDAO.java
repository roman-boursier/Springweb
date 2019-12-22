package com.projet.dao;

import java.util.List;
import com.projet.model.Street_name;

public interface IStreetNameDAO {
		public List<Street_name> recupererListeRue();
		public void removeListeRue(long id);
		public void addListeRue(long id, String name);
		public void updateListeRue(long id, String name);
}
