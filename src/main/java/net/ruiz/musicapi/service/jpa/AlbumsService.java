package net.ruiz.musicapi.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ruiz.musicapi.entity.Album;
import net.ruiz.musicapi.repository.AlbumsRepository;
import net.ruiz.musicapi.service.IAlbumsService;

@Service
public class AlbumsService implements IAlbumsService {

    @Autowired
    private AlbumsRepository albumsRepo;

    @Override
    public List<Album> buscarTodos() {
        return albumsRepo.findAll();
    }

    @Override
    public void guardar(Album album) {
        albumsRepo.save(album);
    }

    @Override
    public void eliminar(int idAlbum) {
        albumsRepo.deleteById(idAlbum);
    }
    
}
