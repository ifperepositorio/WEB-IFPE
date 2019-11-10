package com.ifpe.gacm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifpe.gacm.model.Medico;
import com.ifpe.gacm.repository.MedicoRepository;

@Controller
public class MedicoController {
			
	@Autowired
	private MedicoRepository medicoRepository;

	@GetMapping("/cadastrar") //singup
    public String home(Medico medico) {
       return "CadastroMedico";
}	
	
	@PostMapping("/adduserMedico") //adduser
    public String addUser(@Valid Medico medico, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "adduserMedico";
        }
         
        medicoRepository.save(medico);
        model.addAttribute("users", medicoRepository.findAll());
        return "PesquisaMedico";
    }	
	
	@GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Medico medico = medicoRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
         
        model.addAttribute("medico", medico);
        return "adduserMedico";
    }
	
	@PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Medico medico, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
        	medico.setId(id);
            return "update-user";
        }
             
        medicoRepository.save(medico);
        model.addAttribute("users", medicoRepository.findAll());
        return "index";
    }
         
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Medico medico = medicoRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        medicoRepository.delete(medico);
        model.addAttribute("users", medicoRepository.findAll());
        return "index";
    }
	
	
}
