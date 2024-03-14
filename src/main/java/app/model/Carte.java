package app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@NamedQueries(
        {
                @NamedQuery(name="findBookById",query ="from Carte carte where carte.idCarte= :id"),
                @NamedQuery(name="findBookByDepartment",query ="from Carte carte where carte.idDepartament= :id"),
                @NamedQuery(name="findBookGreaterThan",query ="from Carte carte where carte.pret> :price"),
                @NamedQuery(name ="findAllBooks", query = "from Carte")
        }
)
public class Carte {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCarte")
    private Integer idCarte;

    @Column(name = "titlu")
    private String titlu;

    @Column(name = "cantitate")
    private Integer cantitate;

    @Column(name = "pret")
    private Integer pret;

    @Column(name = "anPublicare")
    private Integer anPublicare;

    @Column(name = "idAutor")
    private Integer idAutor;

    @Column(name = "idDepartament")
    private Integer idDepartament;


    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Autor autor;


}
