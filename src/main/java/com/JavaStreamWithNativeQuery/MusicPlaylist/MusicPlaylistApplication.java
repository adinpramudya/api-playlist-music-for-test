package com.JavaStreamWithNativeQuery.MusicPlaylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class MusicPlaylistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicPlaylistApplication.class, args);
	}

}
