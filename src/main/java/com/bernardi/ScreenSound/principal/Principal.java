package com.bernardi.ScreenSound.principal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.bernardi.ScreenSound.model.Artist;
import com.bernardi.ScreenSound.model.Music;
import com.bernardi.ScreenSound.model.TypeArtist;
import com.bernardi.ScreenSound.repository.ArtistRepository;
import com.bernardi.ScreenSound.service.ChatGPT;

public class Principal {

	private Scanner scanner = new Scanner(System.in);
	
	private ArtistRepository repository;

	public Principal(ArtistRepository repository) {
		this.repository = repository;
	}

	public void showMenu() {
		
		var option = -1;
		
		while(option != 9) {
			
			var menu = """
					
					*** Screen Sound Musics ***
					
					1 - Register an artist
					2 - Register a song
					3 - List of songs
					4 - Search songs by artist
					5 - Search for an artist's data
					
					9 - Exit
										
					""";
			
			System.out.println(menu);
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
			case 1: 
				registerArtist();
				break;
			case 2:
				registerSong();
				break;
			case 3:
				listSongs();
				break;
			case 4: 
				searchSongsByArtist();
				break;
			case 5: 
				searcheArtistData();
				break;
			case 9:
				System.out.println(" Ending the application");
				break;
			default:
				System.out.println("Invalid option! ");
								
				
		}
		
	}

}


	private void searcheArtistData() {
		System.out.println("Searching for data about which artist? ");
		var name = scanner.nextLine();
		var response = ChatGPT.getData(name);
		System.out.println(response);
		
	}

	private void searchSongsByArtist() {
		System.out.println("Search for songs by which artist?");
		var name = scanner.nextLine();
		List<Music> musics = repository.searchSongsByArtist(name);
		musics.forEach(System.out::println);
		
	}

	private void listSongs() {
		List<Artist> artists = repository.findAll();
		artists.forEach(a -> a.getMusics().forEach(System.out::println));
		
	}

	private void registerSong() {
		System.out.println("Which artist's music to record?");
		var name = scanner.nextLine();
		Optional<Artist> artist = repository.findByNameContainingIgnoreCase(name);
		if(artist.isPresent()) {
			System.out.println("Enter the name of the song: ");
			var song = scanner.nextLine();
			Music music = new Music(song);
			music.setArtist(artist.get());
			artist.get().getMusics().add(music);
			repository.save(artist.get());
		}else {
			System.out.println("Artist not found!");
		}
	}

	private void registerArtist() {
		var registerNew = "Y";
		
		while(registerNew.equalsIgnoreCase("y")) {
		System.out.println("Enter the name of the Artist you want to register: ");
		var name = scanner.nextLine();
		System.out.println("Enter the type of Artist: (Solo, Duo or Band)");
		var type = scanner.nextLine();
		TypeArtist typeArtist = TypeArtist.valueOf(type.toUpperCase());
		Artist artist = new Artist(name, typeArtist);
		repository.save(artist);
		System.out.println("Do you want to register a new artist? (Y/N)");
		registerNew = scanner.nextLine();
		}
	}
}
