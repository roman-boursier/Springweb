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

import com.projet.model.City;
import com.projet.model.Language;
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
    
    @RequestMapping(value="/pageVille/remove", method = RequestMethod.GET)
    public String deleteLanguage(ModelMap map, @RequestParam("id") String id) {
    	cityService.removeCity(Long.valueOf(id));
    	List<City> listeVille = cityService.recupererListeVille();
        map.addAttribute("listCity", listeVille);
        return "redirect:/pageVille";
    }
    
    @RequestMapping(value="/pageVille/update", method = RequestMethod.POST)
    public String updateCity(ModelMap map, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("zipLabel") String zipLabel) {
    	cityService.updateCity(Long.valueOf(id), name, zipLabel);
    	List<City> listeVille = cityService.recupererListeVille();
        map.addAttribute("listCity", listeVille);
        return "redirect:/pageVille";
    }
    
    @RequestMapping(value="/pageVille/add", method = RequestMethod.POST)
    public String addCity(ModelMap map, @RequestParam("id") String id, @RequestParam("name") String name,  @RequestParam("zipLabel") String zipLabel) {
    	cityService.addCity(Long.valueOf(id), name, zipLabel);
    	List<City> listeVille = cityService.recupererListeVille();
        map.addAttribute("listCity", listeVille);
        return "redirect:/pageVille";
    }
}


