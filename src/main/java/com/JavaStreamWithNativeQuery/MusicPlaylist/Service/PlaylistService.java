package com.JavaStreamWithNativeQuery.MusicPlaylist.Service;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Playlist;

import java.util.List;

public interface PlaylistService {
    List<Playlist> findAll();

    Playlist findById(Long id);

    void save(Playlist playlist);

    void deleteById(Long id);
}
