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

import com.ifpe.ClinicaGeral.model.Patient;
import com.ifpe.ClinicaGeral.service.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@RequestMapping("/pacientes/novo")
	public ModelAndView novo(Patient patient) {
		ModelAndView mv = new ModelAndView("patients/registerPatients");
		return mv;
	}
	
	@RequestMapping(value = "/pacientes/novo", method = RequestMethod.POST)
	public ModelAndView save(@Valid Patient patient, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return novo(patient);
		}
		
		patientService.save(patient);
		attributes.addFlashAttribute("message", "Registro Salvo com sucesso");
		return new ModelAndView("redirect:/pacientes/novo");
	}
}
