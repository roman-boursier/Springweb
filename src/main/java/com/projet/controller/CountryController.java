package com.projet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.projet.model.Country;
import com.projet.model.Language;
import com.projet.model.Country;
import com.projet.service.ICountryService;

@Controller
public class CountryController {
	
    private ICountryService countryService;
	
    public ICountryService getCountryService() {
		return countryService;
	}
    
    @Autowired(required=true)
    @Qualifier(value="countryService")
	public void setCountryService(ICountryService countryService) {
		this.countryService = countryService;
	}

    @RequestMapping(value="/pagePays", method = RequestMethod.GET)
    public String recupererListePays(ModelMap map) {
    	List<Country> listePays = countryService.recupererListePays();
        map.addAttribute("listCountry", listePays);
        return "pagePays";
    }
    
    @RequestMapping(value="/pagePays/remove", method = RequestMethod.GET)
    public String deleteLanguage(ModelMap map, @RequestParam("id") String id) {
    	countryService.removeCountry(Long.valueOf(id));
    	List<Country> listePays = countryService.recupererListePays();
        map.addAttribute("listCountry", listePays);
        return "redirect:/pagePays";
    }
    
    @RequestMapping(value="/pagePays/update", method = RequestMethod.POST)
    public String updateLanguage(ModelMap map, @RequestParam("id") String id, @RequestParam("code") String code) {
    	countryService.updateCountry(Long.valueOf(id), code);
    	List<Country> listePays = countryService.recupererListePays();
        map.addAttribute("listCountry", listePays);
        return "redirect:/pagePays";
    }
    
    @RequestMapping(value="/pagePays/add", method = RequestMethod.POST)
    public String addLanguage(ModelMap map, @RequestParam("id") String id, @RequestParam("code") String code) {
    	countryService.addCountry(Long.valueOf(id), code);
    	List<Country> listePays = countryService.recupererListePays();
        map.addAttribute("listCountry", listePays);
        return "redirect:/pagePays";
    }
    
    @RequestMapping(value="/autocomplete/country", method = RequestMethod.POST)
    public @ResponseBody String recupererAutoCompleteList(ModelMap map, @RequestParam("term") String searchWorld) {
    	List<Country> listeCountryFiltered = countryService.searchCountry(searchWorld);
    	String json = new Gson().toJson(listeCountryFiltered);
        return json;
    }
    
    @RequestMapping(value="/autocomplete/countrySingle", method = RequestMethod.POST)
    public @ResponseBody String recupererSingle(ModelMap map, @RequestParam("id") String searchId) {
    	Country Country = countryService.getCountry(Integer.valueOf(searchId));
    	String json = new Gson().toJson(Country);
        return json; 	
    }
}



