package com.ifpe.gacm.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ifpe.gacm.model.Especialidades;
import com.ifpe.gacm.model.Medicos;
import com.ifpe.gacm.repository.MedicoRepository;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository medicoRepository;

	@RequestMapping("/novo")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("CadastroMedico");		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)	
	public ModelAndView salvar(Medicos medicos) {
		medicoRepository.save(medicos);
		ModelAndView mv = new ModelAndView("CadastroMedico");
		mv.addObject("mensagem", "Médico salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView listar() {
		List<Medicos> todosMedicos = medicoRepository.findAll();
		ModelAndView mv = new ModelAndView("PesquisaMedico");
		mv.addObject("medicos", todosMedicos);
		return mv;
	}
	
	@ModelAttribute("especialidade")
	public List<Especialidades> especialidade(){
		return Arrays.asList(Especialidades.values());
	}
	
	
	
	
	
}
