package com.bernardi.ScreenSound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bernardi.ScreenSound.principal.Principal;
import com.bernardi.ScreenSound.repository.ArtistRepository;

@SpringBootApplication
public class ScreenSoundApplication implements CommandLineRunner {
	@Autowired
	private ArtistRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenSoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.showMenu();
	}

}
