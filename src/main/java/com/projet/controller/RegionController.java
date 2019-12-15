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

import com.projet.model.Language;
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
    
    @RequestMapping(value="/autocomplete/regions", method = RequestMethod.POST)
    public void recupererAutoCompleteList(ModelMap map, @RequestParam("term") String searchWorld) {
    	List<Region> listeRegions = regionService.recupererListeRegions();
    	List<String> listeRegionsFiltered = new ArrayList();
    	
    	for(int i=0;i<listeRegions.size();i++) {
    		if(listeRegions.get(i).getAreaLabel().contains(searchWorld)){
    			listeRegionsFiltered.add(
					String.valueOf(listeRegions.get(i).getIdArea()) 
					+ "-" + listeRegions.get(i).getAreaLabel()
    			);
    		}
    	}
        map.addAttribute("results", listeRegionsFiltered);
    }
    
    @RequestMapping(value="/autocomplete/regionsSingle", method = RequestMethod.POST)
    public void recupererSingle(ModelMap map, @RequestParam("id") String searchId) {
    	List<Region> listeRegions = regionService.recupererListeRegions();
    	List<String> region = new ArrayList();
    	
    	for(int i=0;i<listeRegions.size();i++) {
    		if(String.valueOf(listeRegions.get(i).getIdArea()).contentEquals(searchId)){
    			region.add(String.valueOf(listeRegions.get(i).getIdArea()));
    			region.add(listeRegions.get(i).getAreaLabel());
    		}
    	}
        map.addAttribute("results", region);    	
    }
}



