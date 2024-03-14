package app.controller.rest;

import app.model.Autor;
import app.model.Carte;
import app.service.AutorService;
import app.single_point_access.ServiceSinglePointAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private AutorService autorService = ServiceSinglePointAccess.getAutorService();
    //merge
    @GetMapping("/id/{id}")
    public ResponseEntity<Autor>getAutorById(@PathVariable Integer id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(autorService.findById(id));
    }
    //merge
    @PostMapping("/create")
    public ResponseEntity<Autor> createUser(@RequestBody Autor autor) {
        return ResponseEntity.status(HttpStatus.OK).body(autorService.save(autor));
    }

//    @GetMapping("/{id}/carti")
//    public List<Carte> getAllBookByAutorId(@PathVariable("id") Integer id)
//    {
//        return autorService.getAllBookByAutorId(id);
//    }
}
