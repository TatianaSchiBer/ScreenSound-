package com.bernardi.ScreenSound.principal;

import java.util.Scanner;

public class Principal {

	private Scanner leitura = new Scanner(System.in);

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
			option = leitura.nextInt();
			leitura.nextLine();
			
			switch (option) {
			case 1: 
				registerArtist();
				break;
			case 2:
				registerArtist();
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
		// TODO Auto-generated method stub
		
	}

	private void searchSongsByArtist() {
		// TODO Auto-generated method stub
		
	}

	private void listSongs() {
		// TODO Auto-generated method stub
		
	}

	private void registerArtist() {
		// TODO Auto-generated method stub
		
	}
}
