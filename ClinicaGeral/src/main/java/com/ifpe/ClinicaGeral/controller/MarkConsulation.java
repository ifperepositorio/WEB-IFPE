package com.ifpe.ClinicaGeral.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifpe.ClinicaGeral.model.MedicalConsultation;
import com.ifpe.ClinicaGeral.repository.Doctors;
import com.ifpe.ClinicaGeral.repository.Hour;
import com.ifpe.ClinicaGeral.repository.Patients;
import com.ifpe.ClinicaGeral.service.MedicalConsulationService;

@Controller
public class MarkConsulation {
	
	@Autowired
	private Hour hours;
	
	@Autowired
	private Patients patients;
	
	@Autowired
	private Doctors doctors;
	
	@Autowired
	private MedicalConsulationService medService;

	@RequestMapping("/consultas/novo")
	public ModelAndView novo(MedicalConsultation medicalConsultation) {
		ModelAndView mv = new ModelAndView("consulation/markConsulation");
		mv.addObject("hours", hours.findAll());
		mv.addObject("patients", patients.findAll());
		mv.addObject("doctors", doctors.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/consultas/novo", method = RequestMethod.POST)
	public ModelAndView save(@Valid MedicalConsultation med, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return novo(med);
		}
		
		medService.save(med);
		
       redirectAttributes.addFlashAttribute("message", "Registro salvo com sucesso");
		
		
		return new ModelAndView("redirect:/consultas/novo");
		
	}
	
}
