package app.single_point_access;

import app.repository.AutorRepository;
import app.repository.CarteRepository;
import app.repository.implemetation.AutorRepositoryImpl;
import app.repository.implemetation.CarteRepositoryImpl;

public class RepositorySinglePointAccess {


    private static CarteRepository carteRepository;
    private static AutorRepository autorRepository;


    static {


        carteRepository = new CarteRepositoryImpl();
        autorRepository = new AutorRepositoryImpl();

    }


    public static CarteRepository getCarteRepository(){return carteRepository;}
    public static AutorRepository getAutorRepository(){return autorRepository;}


}
