package app.service;

import app.model.Autor;
import app.model.Carte;

import java.util.List;

public interface AutorService {
    Autor save(Autor autor);
    Autor findById(Integer id);

    //List<Carte> getAllBookByAutorId(Integer id);
}
