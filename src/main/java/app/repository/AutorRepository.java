package app.repository;

import app.model.Autor;
import app.model.Carte;

import javax.persistence.Query;
import java.util.List;

public interface AutorRepository extends CRUDRepository<Autor,Integer> {

    //List<Carte> getAllBookByAutorId(Integer id);
}
