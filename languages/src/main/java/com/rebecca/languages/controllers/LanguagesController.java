package com.rebecca.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rebecca.languages.models.Language;
import com.rebecca.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguagesController {
	private final LanguageService langServ; 
	
	public LanguagesController(LanguageService langServ) {
		this.langServ = langServ; 
	}
	
	//show all
	@RequestMapping("")
	public String index(@ModelAttribute("language") Language language, Model model) {
        List<Language> languages = langServ.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }
	
	//process create new
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/index.jsp"; 
		}
		
		langServ.createLanguage(language); 
		return "redirect:/languages";
	}
	
	//show one
	@RequestMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		Language lang = langServ.findLanguage(id); 
		model.addAttribute("language", lang); 
		return "/languages/show.jsp"; 
	}
	
	//edit view
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, @ModelAttribute("language") Language language, Model model) {
		Language lang = langServ.findLanguage(id); 
		model.addAttribute("language", lang); 
		return "/languages/edit.jsp"; 
	}
	
	//update 
	@PutMapping("/edit/{id}")
	public String update(@PathVariable Long id, @Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		model.addAttribute("language", langServ.findLanguage(id)); 
		if(result.hasErrors()) {
			return "/languages/edit.jsp"; 
		}
		
		langServ.updateLanguage(language); 
		return "redirect:/languages"; 
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
		langServ.deleteLanguage(id);
		return "redirect:/languages"; 
	}
	

}
