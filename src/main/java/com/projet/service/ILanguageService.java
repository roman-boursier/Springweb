package com.projet.service;

import java.util.List;

import com.projet.model.Language;

public interface ILanguageService {
	public List<Language> recupererListeLangage();
	public void removeLanguage(long id);
	public void addLanguage(long id, String code, String name);
	public void updateLanguage(long id, String code, String name);
}
