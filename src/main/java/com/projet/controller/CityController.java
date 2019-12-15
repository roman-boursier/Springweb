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

import com.projet.model.City;
import com.projet.service.ICityService;

@Controller
public class CityController {
	
    private ICityService cityService;
	
    public ICityService getCityService() {
		return cityService;
	}
    
    @Autowired(required=true)
    @Qualifier(value="cityService")
	public void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}

    @RequestMapping(value="/pageVille", method = RequestMethod.GET)
    public String recupererListeVille(ModelMap map) {
    	List<City> listeVille = cityService.recupererListeVille();
        map.addAttribute("listCity", listeVille);
        return "pageVille";
    }
}



