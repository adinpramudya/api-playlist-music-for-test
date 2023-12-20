package com.JavaStreamWithNativeQuery.MusicPlaylist.Service;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Playlist;
import com.JavaStreamWithNativeQuery.MusicPlaylist.Repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist findById(Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public void deleteById(Long id) {
        playlistRepository.deleteById(id);
    }
}
