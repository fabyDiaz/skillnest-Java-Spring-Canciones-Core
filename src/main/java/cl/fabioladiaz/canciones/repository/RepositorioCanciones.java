package cl.fabioladiaz.canciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.fabioladiaz.canciones.model.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long>{
    List<Cancion> findAll();
}
