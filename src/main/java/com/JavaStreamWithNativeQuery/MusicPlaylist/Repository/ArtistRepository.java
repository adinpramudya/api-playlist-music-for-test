package com.JavaStreamWithNativeQuery.MusicPlaylist.Repository;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Long> {

}
