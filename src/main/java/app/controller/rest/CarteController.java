package app.controller.rest;

import app.model.Carte;
import app.service.CarteService;
import app.single_point_access.ServiceSinglePointAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carte")
public class CarteController {
    private CarteService carteService= ServiceSinglePointAccess.getCarteService();


    @PostMapping("/create")
    public ResponseEntity<Carte> saveCarte(@RequestBody Carte carte){
        return ResponseEntity.status(HttpStatus.OK).body(carteService.saveCarte(carte));
    }

//    @PostMapping("/exemplu")
//    public String printUser(@RequestBody Carte carte)
//    {
//        System.out.println("printing de user object: " + carte);
//        return "Success";
//    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Carte> getUserById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(carteService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Carte>> getAllBook(){
        return ResponseEntity.status(HttpStatus.OK).body(carteService.findAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Carte> update(@RequestBody Carte carte){
        Carte carteDinDb = carteService.findById(carte.getIdCarte());
        carteDinDb.setPret(carte.getPret());
        carteDinDb.setTitlu(carte.getTitlu());
        carteDinDb.setAnPublicare(carte.getAnPublicare());
        carteDinDb.setCantitate(carte.getCantitate());
        Carte carteUpdate = carteService.update(carteDinDb);
        return ResponseEntity.status(HttpStatus.OK).body(carteUpdate);
    }


    @DeleteMapping("/delete/{id}") //@DeleteMapping("/delete")
    public ResponseEntity<Boolean>deleteById(@PathVariable Integer id){ //@RequestBody
        Carte carte = carteService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carteService.delete(carte));
    }
}
