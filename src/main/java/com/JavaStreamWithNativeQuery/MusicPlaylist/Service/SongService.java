package com.JavaStreamWithNativeQuery.MusicPlaylist.Service;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Song;

import java.util.List;

public interface SongService {

    List<Song> findAll();

    Song findById(Long id);

    void save(Song song);

    void deleteById(Long id);

    List<Song> findSongsByArtistId(Long artistId);

    List<Song> findSongsWithDurationLessThan(double duration);

    List<Song> findSongsByArtistName(String artistName);
}
