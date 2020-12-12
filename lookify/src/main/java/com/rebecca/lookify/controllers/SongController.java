package com.rebecca.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rebecca.lookify.models.Song;
import com.rebecca.lookify.services.SongService;

@Controller
public class SongController {
	@Autowired
	private SongService songServ; 
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songServ.allSongs(); 
		model.addAttribute("songs", songs); 
		return "dashboard.jsp"; 
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "songs/new.jsp"; 
	}
	
	@PostMapping("/songs/new")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "songs/new.jsp"; 
		}
		
		songServ.createSong(song); 
		
		return "redirect:/dashboard"; 
	}
	
	@GetMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
			Song song = songServ.findSong(id);
			model.addAttribute("song", song);
			return "songs/show.jsp"; 
				
	}
	
	@DeleteMapping("/songs/{id}")
	public String destroy(@PathVariable("id") Long id) {
		songServ.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/search/topTen")
	public String showTopTen(Model model) {
		List<Song> songs = songServ.songsByRating(); 
		model.addAttribute("songs", songs);
		return "search/topTen.jsp"; 
	}
	
	@PostMapping("/search")
	public String searchArtist(@RequestParam("search") String search, RedirectAttributes result) {
		List<Song> songs = songServ.songsByArtist(search); 
		result.addFlashAttribute("songs", songs); 
		return "redirect:/search/" + search; 
	}
	
	@GetMapping("/search/{artist}")
	public String showSongsByArtist(@PathVariable("artist") String artist, Model model) {
		model.addAttribute("artist", artist); 
		return "search/artist.jsp"; 
	}

}
