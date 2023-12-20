package com.JavaStreamWithNativeQuery.MusicPlaylist.Contoroller;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Artist;
import com.JavaStreamWithNativeQuery.MusicPlaylist.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.findAll();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        Artist artist = artistService.findById(id);
        return artist != null
                ? new ResponseEntity<>(artist, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> createArtist(@RequestBody Artist artist) {
        artistService.save(artist);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        Artist existingArtist = artistService.findById(id);
        if (existingArtist != null) {
            // Update the existing artist with the new data
            existingArtist.setName(artist.getName());
            existingArtist.setSongs(artist.getSongs());

            System.out.println("LOG >>>>>>> "+existingArtist);
            artistService.save(existingArtist);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
