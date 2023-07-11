package net.ruiz.musicapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ruiz.musicapi.entity.Album;

public interface AlbumsRepository extends JpaRepository<Album, Integer> {
    
}
