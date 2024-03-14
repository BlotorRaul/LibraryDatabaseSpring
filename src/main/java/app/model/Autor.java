package app.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table
@Data
public class Autor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAutor")
    private Integer idAutor;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "dataNasterii")
    private Date dataNasterii;

    @Column(name = "taraNatala")
    private String taraNatala;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "autor",fetch = FetchType.EAGER)
    private List<Carte> carti;


}
