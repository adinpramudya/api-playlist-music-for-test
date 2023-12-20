package com.JavaStreamWithNativeQuery.MusicPlaylist.Service;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> findAll();

    Artist findById(Long id);

    void save(Artist artist);

    void deleteById(Long id);
}
