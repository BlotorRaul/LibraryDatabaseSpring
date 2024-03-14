package app.single_point_access;

import app.service.AutorService;
import app.service.CarteService;
import app.service.implementation.AutorServiceImpl;
import app.service.implementation.CarteServiceImpl;

public class ServiceSinglePointAccess {


    private static CarteService carteService;
    private static AutorService autorService;

    static {
        carteService = new CarteServiceImpl();
        autorService = new AutorServiceImpl();
    }


    public static CarteService getCarteService(){return carteService;}
    public static AutorService getAutorService(){return autorService;}

}
