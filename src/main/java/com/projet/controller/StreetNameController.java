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
}



