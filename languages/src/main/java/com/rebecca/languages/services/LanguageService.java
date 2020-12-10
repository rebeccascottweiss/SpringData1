package com.rebecca.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rebecca.languages.models.Language;
import com.rebecca.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	//adds repository as a dependency
	private final LanguageRepository langRepo; 
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo; 
	}
	//this is where your crud commands go
	
	 // returns all the books
    public List<Language> allLanguages() {
        return langRepo.findAll();
    }
    // creates a book
    public Language createLanguage(Language l) {
        return langRepo.save(l);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = langRepo.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
    	Optional<Language> optionalLanguage = langRepo.findById(id); 
    	
    	if(optionalLanguage.isPresent()) {
    		Language l = optionalLanguage.get(); 
    		l.setName(name);
    		l.setCreator(creator);
    		l.setCurrentVersion(currentVersion);
    		return langRepo.save(l); 
    	} else {
    		return null; 
    	}
    }
    
    public Language updateLanguage(Language language) {
		return langRepo.save(language); 
    }
    
    public void deleteLanguage(Long id) {
    	langRepo.deleteById(id);
    }
}
