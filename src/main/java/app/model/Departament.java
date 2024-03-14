package app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Departament {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDepartament")
    private Integer idDepartament;

    @Column(name = "nume")
    private String nume;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "idResponsabilDepartament")
    private Integer idResponsabilDepartament;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Carte> carti;
}
