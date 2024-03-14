package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
@Data
public class Contract {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idContract")
    private Integer idContract;

    @Column(name = "idBibliotecara")
    private Integer idBibliotecara;

    @Column(name = "idImprumutor")
    private Integer idImprumutor;

    @Column(name = "idCarte")
    private Integer idCarte;

    @Column(name = "dataIncepereCarteImprumutata")
    private Date dataIncepereCarteImprumutata;

    @Column(name = "dataExpirareCarteImprumutata")
    private Date dataExpirareCarteImprumutata;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @ToString.Exclude
//    @JsonIgnore
//    private Carte carte;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @ToString.Exclude
//    @JsonIgnore
//    private Imprumutor imprumutor;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @ToString.Exclude
//    @JsonIgnore
//    private Bibliotecara bibliotecara;
}
