package cl.fabioladiaz.canciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.fabioladiaz.canciones.model.Artista;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long> {

    List<Artista> findAll();

}
