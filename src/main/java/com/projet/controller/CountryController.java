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
}



