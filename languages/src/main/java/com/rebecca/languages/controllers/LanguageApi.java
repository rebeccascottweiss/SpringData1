package com.rebecca.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rebecca.languages.models.Language;
import com.rebecca.languages.services.LanguageService;

@RestController
public class LanguageApi {
	private final LanguageService langServ; 
	
	public LanguageApi(LanguageService langServ) {
		this.langServ = langServ; 
	}
	
	//this is where you do your api requests
	
	//get all
	@RequestMapping("/api/languages")
    public List<Language> index() {
        return langServ.allLanguages();
    }
    
	//create new
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam String name, @RequestParam String creator, @RequestParam String currentVersion) {
        Language language = new Language(name, creator, currentVersion);
        return langServ.createLanguage(language);
    }
    
    //find one by id
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = langServ.findLanguage(id);
        return language;
    }
    
    //update by id
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam String name, @RequestParam String creator, @RequestParam String currentVersion) {
        Language language = langServ.updateLanguage(id, name, creator, currentVersion);
        return language;
    }
    
    //delete by id
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        langServ.deleteLanguage(id);
    }

}
