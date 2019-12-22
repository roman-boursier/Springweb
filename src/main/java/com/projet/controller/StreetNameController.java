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
import com.projet.model.Street_name;
import com.projet.service.IStreetNameService;

@Controller
public class StreetNameController {
	
    private IStreetNameService streetNameService;
	
    public IStreetNameService getStreetNameService() {
		return streetNameService;
	}
    
    @Autowired(required=true)
    @Qualifier(value="streetNameService")
	public void setStreetNameService(IStreetNameService streetNameService) {
		this.streetNameService = streetNameService;
	}

    @RequestMapping(value="/pageRue", method = RequestMethod.GET)
    public String recupererListeRue(ModelMap map) {
    	List<Street_name> listeRue = streetNameService.recupererListeRue();
        map.addAttribute("listStreet", listeRue);
        return "pageRue";
    }
    
    @RequestMapping(value="/pageRue/remove", method = RequestMethod.GET)
    public String deleteListeRue(ModelMap map, @RequestParam("id") String id) {
    	streetNameService.removeListeRue(Long.valueOf(id));
    	List<Street_name> listeRue = streetNameService.recupererListeRue();
        map.addAttribute("listStreet", listeRue);
        return "redirect:/pageRue";
    }
    
    @RequestMapping(value="/pageRue/update", method = RequestMethod.POST)
    public String updateListeRue(ModelMap map, @RequestParam("id") String id, @RequestParam("name") String name) {
    	streetNameService.updateListeRue(Long.valueOf(id), name);
    	List<Street_name> listeRue = streetNameService.recupererListeRue();
        map.addAttribute("listStreet", listeRue);
        return "redirect:/pageRue";
    }
    
    @RequestMapping(value="/pageRue/add", method = RequestMethod.POST)
    public String addListeRue(ModelMap map, @RequestParam("id") String id, @RequestParam("name") String name) {
    	streetNameService.addListeRue(Long.valueOf(id), name);
    	List<Street_name> listeRue = streetNameService.recupererListeRue();
        map.addAttribute("listStreet", listeRue);
        return "redirect:/pageRue";
    }
    
    @RequestMapping(value="/autocomplete/street", method = RequestMethod.POST)
    public @ResponseBody String recupererAutoCompleteList(ModelMap map, @RequestParam("term") String searchWorld) {
    	List<Street_name> listeListeRueFiltered = streetNameService.searchListeRue(searchWorld);
    	String json = new Gson().toJson(listeListeRueFiltered);
        return json;
    }
    
    @RequestMapping(value="/autocomplete/streetSingle", method = RequestMethod.POST)
    public @ResponseBody String recupererSingle(ModelMap map, @RequestParam("id") String searchId) {
    	Street_name ListeRue = streetNameService.getListeRue(Integer.valueOf(searchId));
    	String json = new Gson().toJson(ListeRue);
        return json; 	
    }
}



