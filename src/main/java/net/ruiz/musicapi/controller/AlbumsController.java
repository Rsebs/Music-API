package net.ruiz.musicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ruiz.musicapi.entity.Album;
import net.ruiz.musicapi.service.IAlbumsService;

@RestController
@RequestMapping("/api")
public class AlbumsController {
    
    @Autowired
    private IAlbumsService albumsService;

    //Por convención en las RestFullApi se utuliza el método:
    //HTTP GET para consultar
    @GetMapping("/albums")
    public List<Album> buscarTodos() {
        return albumsService.buscarTodos();
    }
    
    //HTTP POST para guardar
    @PostMapping("/albums")
    public Album guardar(@RequestBody Album album) {
        albumsService.guardar(album);
        return album;
    }

    //HTTP PUT para modificar
    @PutMapping("/albums")
    public Album modificar(@RequestBody Album album) {
        //El método guardar sirve también para modificar, para modificar sólo se debe enviar el valor de la clave primaria
        albumsService.guardar(album);
        return album;
    }

    //HTTP DELETE para eliminar
    @DeleteMapping("/albums/{id}")
    public String eliminar(@PathVariable("id") int idAlbum) {
        albumsService.eliminar(idAlbum);
        return "Registro eliminado";
    }
}
