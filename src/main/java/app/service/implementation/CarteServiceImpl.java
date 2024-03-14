package app.service.implementation;

import app.model.Carte;
import app.repository.CarteRepository;
import app.service.CarteService;
import app.single_point_access.RepositorySinglePointAccess;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarteServiceImpl implements CarteService {
    private CarteRepository carteRepository = RepositorySinglePointAccess.getCarteRepository();
    @Override
    public Carte saveCarte(Carte carte) {
        return carteRepository.save(carte);
    }

    public Carte findById(Integer id){
        return carteRepository.findById(id);
    }

    public List<Carte> findAll(){
        return carteRepository.findAll();
    }
    public Carte update(Carte carte){
        return carteRepository.update(carte);
    }
    @Override
    public boolean delete(Carte carte) {
        return carteRepository.delete(carte);
    }
}
