package com.mobil.ws.application.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CatalogoController {

	@RequestMapping(value = "/index", method =  RequestMethod.GET)
	public String helloWorld(Model model){
		model.addAttribute("titulo", "Catalogo de mezcales");
	    model.addAttribute("productos", "Lista de productos");
	    return "index";	
	}
	
	@RequestMapping(value = "/listaModelAndView", method =  RequestMethod.GET)
	public ModelAndView listarModelAndView() {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("titulo", "Catalogo de mezcales");
	    mav.addObject("productos", "Lista de productos");
	    mav.setViewName("index");
	    return mav;
	}
	
}
