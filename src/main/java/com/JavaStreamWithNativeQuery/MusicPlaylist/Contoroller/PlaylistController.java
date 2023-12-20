package com.JavaStreamWithNativeQuery.MusicPlaylist.Contoroller;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Playlist;
import com.JavaStreamWithNativeQuery.MusicPlaylist.Service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        List<Playlist> playlists = playlistService.findAll();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long id) {
        Playlist playlist = playlistService.findById(id);
        return playlist != null
                ? new ResponseEntity<>(playlist, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> createPlaylist(@RequestBody Playlist playlist) {
        playlistService.save(playlist);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {
        Playlist existingPlaylist = playlistService.findById(id);
        if (existingPlaylist != null) {
            // Update the existing playlist with the new data
            existingPlaylist.setName(playlist.getName());
            existingPlaylist.setSongs(playlist.getSongs());
            playlistService.save(existingPlaylist);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
