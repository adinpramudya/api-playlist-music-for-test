package com.JavaStreamWithNativeQuery.MusicPlaylist.Service;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Song;
import com.JavaStreamWithNativeQuery.MusicPlaylist.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl  implements SongService{
    private final SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public List<Song> findSongsByArtistId(Long artistId) {
        return songRepository.findSongsByArtistId(artistId);
    }

    @Override
    public List<Song> findSongsWithDurationLessThan(double duration) {
        return findAll().stream()
                .filter(song -> song.getDuration() < duration)
                .collect(Collectors.toList());
    }


    @Override
    public List<Song> findSongsByArtistName(String artistName) {

            try {
                return songRepository.findSongsByArtistName(artistName);
            } catch (Exception e) {
                // Handle the exception or log it
                e.printStackTrace();
                throw new RuntimeException("Error fetching songs by artist name");
            }
    }
}
