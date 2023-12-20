package com.JavaStreamWithNativeQuery.MusicPlaylist.Repository;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song,Long> {

    @Query(value = "SELECT * FROM Song where artist_id = ?1",nativeQuery = true)
    List<Song> findSongsByArtistId(Long artistId);

    @Query(value = "SELECT * FROM Song WHERE artist_id IN (SELECT id FROM Artist WHERE name = ?1)", nativeQuery = true)
    List<Song> findSongsByArtistName(String artistName);
}
