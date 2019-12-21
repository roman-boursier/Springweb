package com.projet.dao;

import java.util.List;
import com.projet.model.Language;

public interface ILanguageDAO {

		public List<Language> recupererListeLangage();
		public void removeLanguage(long id);
		public void addLanguage(long id, String code, String name);
		public void updateLanguage(long id, String code, String name);
}
