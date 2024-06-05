package com.bernardi.ScreenSound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bernardi.ScreenSound.model.Artist;
import com.bernardi.ScreenSound.model.Music;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

	Optional<Artist> findByNameContainingIgnoreCase(String name);
	
	@Query("SELECT m FROM Artist a JOIN a.musics m WHERE a.name ILIKE %:name%")
	List<Music> searchSongsByArtist(String name);

}
