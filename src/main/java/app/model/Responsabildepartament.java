package app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Responsabildepartament {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idResponsabilDepartament")
    private Integer idResponsabilDepartament;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "vechime")
    private Integer vechime;

    //@OneToOne(cascade = CascadeType.ALL)
    //private Departament departamente;
}
