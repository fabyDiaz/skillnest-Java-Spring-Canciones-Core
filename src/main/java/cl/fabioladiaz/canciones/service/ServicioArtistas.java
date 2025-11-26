package cl.fabioladiaz.canciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fabioladiaz.canciones.model.Artista;
import cl.fabioladiaz.canciones.repository.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    RepositorioArtistas repositorioArtistas;

    public List<Artista> obtenerTodosLosArtistas(){
        return repositorioArtistas.findAll();
    }

    public Artista obtenerArtistaPorId(Long id){
        return repositorioArtistas.findById(id).orElse(null);
    }

    public Artista agregarArtista(Artista artista){
        return repositorioArtistas.save(artista);
    }

}
