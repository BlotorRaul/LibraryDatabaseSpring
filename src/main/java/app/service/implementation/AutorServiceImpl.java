package app.service.implementation;

import app.model.Autor;
import app.model.Carte;
import app.repository.AutorRepository;
import app.repository.CarteRepository;
import app.service.AutorService;
import app.single_point_access.RepositorySinglePointAccess;

import java.util.List;

public class AutorServiceImpl implements AutorService {
    private AutorRepository autorRepository = RepositorySinglePointAccess.getAutorRepository();
    private CarteRepository carteRepository =RepositorySinglePointAccess.getCarteRepository();
    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor findById(Integer id) {
        return autorRepository.findById(id);
    }

//    @Override
//    public List<Carte> getAllBookByAutorId(Integer id) {
//        //return autorRepository.getAllBookByAutorId(id);
//        Autor autor = autorRepository.findById(id);
//        if (autor != null) {
//            return carteRepository.findByAutor(autor);
//        }
//        return null;
//    }
}
