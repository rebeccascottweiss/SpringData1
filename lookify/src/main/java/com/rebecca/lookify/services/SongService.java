package com.rebecca.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.lookify.models.Song;
import com.rebecca.lookify.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepo; 
	
	//create
	//create a new song
	public Song createSong(Song song) {
		return songRepo.save(song); 
	}
	
	//read
	//return all songs
	public List<Song> allSongs(){
		return songRepo.findAll(); 
	}
	
	//return all songs by an artist
	public List<Song> songsByArtist(String search){
		return songRepo.findByArtistContaining(search);
	}
	
	//return sorted list by rating
	public List<Song> songsByRating(){
		return songRepo.findTop10ByOrderByRatingDesc(); 
	}
	
	//return song by id
	public Song findSong(Long id) {
		Optional<Song> song = songRepo.findById(id); 
		if(song.isPresent()) {
			return song.get(); 
		} else {
			return null; 
		}
	}
	
	//update
	//update existing song
	public Song updateSong(Song song) {
		return songRepo.save(song); 
	}
	
	//delete
	
	public void deleteSong(Long id) {
		songRepo.deleteById(id);
	}
	
	
}
