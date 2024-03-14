package app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Bibliotecara {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idBibliotecara")
    private Integer idBibliotecara;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "email")
    private String email;

    @Column(name = "telefon")
    private String telefon;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Contract> contacte;
}
