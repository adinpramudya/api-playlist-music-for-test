package com.JavaStreamWithNativeQuery.MusicPlaylist.Repository;

import com.JavaStreamWithNativeQuery.MusicPlaylist.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
}
