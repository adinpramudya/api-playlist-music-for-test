package com.JavaStreamWithNativeQuery.MusicPlaylist.Contoroller;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Song;
import com.JavaStreamWithNativeQuery.MusicPlaylist.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.findAll();
        return new ResponseEntity<List<Song>>(songs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        Song song = songService.findById(id);
        return song != null
                ? new ResponseEntity<>(song, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/ByArtistName/{name}")
    public ResponseEntity<List<Song>> getSongsByArtistName(@PathVariable String name) {
        List<Song> songs = songService.findSongsByArtistName(name);
        return songs != null && !songs.isEmpty()
                ? new ResponseEntity<>(songs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @PostMapping
    public ResponseEntity<Void> createSong(@RequestBody Song song) {
        songService.save(song);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSong(@PathVariable Long id, @RequestBody Song song) {
        Song existingSong = songService.findById(id);
        if (existingSong != null) {
            // Update the existing song with the new data
            existingSong.setTitle(song.getTitle());
            existingSong.setDuration(song.getDuration());
            existingSong.setArtist(song.getArtist());
            songService.save(existingSong);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
