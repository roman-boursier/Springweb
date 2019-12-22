package com.projet.controller;

import java.util.ArrayList;
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
import com.projet.model.Region;
import com.projet.model.Region;
import com.projet.model.Region;
import com.projet.service.IRegionService;

@Controller
public class RegionController {
	
    private IRegionService regionService;
	
    public IRegionService getRegionService() {
		return regionService;
	}
    
    @Autowired(required=true)
    @Qualifier(value="regionService")
	public void setRegionService(IRegionService regionService) {
		this.regionService = regionService;
	}
    
    @RequestMapping(value="/pageRegions", method = RequestMethod.GET)
    public String recupererListeRegions(ModelMap map) {
    	List<Region> listeRegions = regionService.recupererListeRegions();
        map.addAttribute("listRegions", listeRegions);
        return "pageRegions";
    }
    

    @RequestMapping(value="/pageRegions/remove", method = RequestMethod.GET)
    public String deleteRegion(ModelMap map, @RequestParam("id") String id) {
    	regionService.removeRegion(Long.valueOf(id));
    	List<Region> listeRegion = regionService.recupererListeRegions();
        map.addAttribute("listRegions", listeRegion);
        return "redirect:/pageRegions";
    }
    
    @RequestMapping(value="/pageRegions/update", method = RequestMethod.POST)
    public String updateRegion(ModelMap map, @RequestParam("id") String id, @RequestParam("name") String name) {
    	regionService.updateRegion(Long.valueOf(id), name);
    	List<Region> listeRegion = regionService.recupererListeRegions();
        map.addAttribute("listRegions", listeRegion);
        return "redirect:/pageRegions";
    }
    
    @RequestMapping(value="/pageRegions/add", method = RequestMethod.POST)
    public String addRegion(ModelMap map, @RequestParam("id") String id, @RequestParam("name") String name) {
    	regionService.addRegion(Long.valueOf(id), name);
    	List<Region> listeRegion = regionService.recupererListeRegions();
        map.addAttribute("listRegions", listeRegion);
        return "redirect:/pageRegions";
    }
    
    @RequestMapping(value="/autocomplete/regions", method = RequestMethod.POST)
    public @ResponseBody String recupererAutoCompleteList(ModelMap map, @RequestParam("term") String searchWorld) {
    	List<Region> listeRegionFiltered = regionService.searchRegion(searchWorld);
    	String json = new Gson().toJson(listeRegionFiltered);
        return json;
    }
    
    @RequestMapping(value="/autocomplete/regionsSingle", method = RequestMethod.POST)
    public @ResponseBody String recupererSingle(ModelMap map, @RequestParam("id") String searchId) {
    	Region Region = regionService.getRegion(Integer.valueOf(searchId));
    	String json = new Gson().toJson(Region);
        return json; 	
    }
}



