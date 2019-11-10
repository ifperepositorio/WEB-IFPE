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

import com.ifpe.ClinicaGeral.model.Doctor;
import com.ifpe.ClinicaGeral.repository.Especialtys;
import com.ifpe.ClinicaGeral.service.RegisterDoctorService;

@Controller
public class DoctorController {
	
	@Autowired
	private Especialtys especialty;
	
	@Autowired
	private RegisterDoctorService doctorService;
	
	@RequestMapping("/medicos/novo")
	public ModelAndView novo(Doctor doctor) {
		ModelAndView mv = new ModelAndView("doctor/registerDoctor");
		mv.addObject("especialtys", especialty.findAll());
		return mv;
	}

	@RequestMapping(value = "/medicos/novo", method = RequestMethod.POST)
	public ModelAndView save(@Valid Doctor doctor, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return novo(doctor);
		}
		
		doctorService.save(doctor);
		redirectAttributes.addFlashAttribute("message", "Registro salvo com sucesso");
		
		
		return new ModelAndView("redirect:/medicos/novo");
	}
	
}






