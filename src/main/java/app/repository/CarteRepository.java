package app.repository;

import app.model.Autor;
import app.model.Carte;

import java.util.List;

public interface CarteRepository extends CRUDRepository<Carte,Integer>{
    //List<Carte> findByAutor(Autor autor);
}
