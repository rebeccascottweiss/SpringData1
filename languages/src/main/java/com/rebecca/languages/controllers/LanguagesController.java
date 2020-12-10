package com.rebecca.languages.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("")
	public String index(Model model) {
        List<Language> languages = langServ.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }

}
