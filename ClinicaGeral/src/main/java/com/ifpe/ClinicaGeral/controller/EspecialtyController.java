package com.ifpe.ClinicaGeral.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifpe.ClinicaGeral.model.Especialty;
import com.ifpe.ClinicaGeral.service.EspecialtyService;

@Controller
public class EspecialtyController {

		
	@Autowired
	private EspecialtyService especialtyService;
	
	@RequestMapping("/especialidades/novo")
	public ModelAndView novo(Especialty especialty) {
		ModelAndView mv = new ModelAndView("especialty/registerEspecialtyNoModal");
		
		return mv;
	}
	
	@RequestMapping(value = "/especialidades/novo", method = RequestMethod.POST)
	public ModelAndView save(@Valid Especialty especialty, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return novo(especialty);
		}
		
		especialtyService.save(especialty);
		attributes.addFlashAttribute("message", "Salvo com sucesso");
		
		return new ModelAndView("redirect:/especialidades/novo");
	}
}
