package app.service;

import app.model.Carte;

import java.util.List;

public interface CarteService {
    Carte saveCarte(Carte carte);
    Carte findById(Integer id);
    List<Carte> findAll();
    Carte update(Carte user);

    boolean delete(Carte carte);
}
