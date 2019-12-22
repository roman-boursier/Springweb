package com.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.projet.model.Language;
import com.projet.service.ILanguageService;

import java.util.ArrayList;
import java.util.StringTokenizer;

@Controller
public class LanguageController {
	
    private ILanguageService languageService;
	
    public ILanguageService getLanguageService() {
		return languageService;
	}
    
    @Autowired(required=true)
    @Qualifier(value="languageService")
	public void setCountryService(ILanguageService languageService) {
		this.languageService = languageService;
	}

    @RequestMapping(value="/pageLangage", method = RequestMethod.GET)
    public String recupererListeLangage(ModelMap map) {
    	List<Language> listeLangage = languageService.recupererListeLangage();
        map.addAttribute("listLanguage", listeLangage);
        return "pageLangage";
    }
    
    @RequestMapping(value="/pageLangage/remove", method = RequestMethod.GET)
    public String deleteLanguage(ModelMap map, @RequestParam("id") String id) {
    	languageService.removeLanguage(Long.valueOf(id));
    	List<Language> listeLangage = languageService.recupererListeLangage();
        map.addAttribute("listLanguage", listeLangage);
        return "redirect:/pageLangage";
    }
    
    @RequestMapping(value="/pageLangage/update", method = RequestMethod.POST)
    public String updateLanguage(ModelMap map, @RequestParam("id") String id, @RequestParam("code") String code,  @RequestParam("name") String name) {
    	languageService.updateLanguage(Long.valueOf(id), code, name);
    	List<Language> listeLangage = languageService.recupererListeLangage();
        map.addAttribute("listLanguage", listeLangage);
        return "redirect:/pageLangage";
    }
    
    @RequestMapping(value="/pageLangage/add", method = RequestMethod.POST)
    public String addLanguage(ModelMap map, @RequestParam("id") String id, @RequestParam("code") String code,  @RequestParam("name") String name) {
    	languageService.addLanguage(Long.valueOf(id), code, name);
    	List<Language> listeLangage = languageService.recupererListeLangage();
        map.addAttribute("listLanguage", listeLangage);
        return "redirect:/pageLangage";
    }
    
    @RequestMapping(value="/autocomplete/language", method = RequestMethod.POST)
    public @ResponseBody String recupererAutoCompleteList(ModelMap map, @RequestParam("term") String searchWorld) {
    	List<Language> listeLangageFiltered = languageService.searchLangage(searchWorld);
    	String json = new Gson().toJson(listeLangageFiltered);
        return json;
    }
    
    @RequestMapping(value="/autocomplete/languageSingle", method = RequestMethod.POST)
    public @ResponseBody String recupererSingle(ModelMap map, @RequestParam("id") String searchId) {
    	Language Langage = languageService.getLanguage(Long.valueOf(searchId));
    	String json = new Gson().toJson(Langage);
        return json; 	
    }

}



