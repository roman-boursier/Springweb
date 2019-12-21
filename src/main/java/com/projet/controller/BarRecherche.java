package com.projet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BarRecherche {
	
	@RequestMapping(value="/BarRecherche", method = RequestMethod.GET)
    public String showBarRecherche() {
        return "BarRecherche";
    }
	
}
