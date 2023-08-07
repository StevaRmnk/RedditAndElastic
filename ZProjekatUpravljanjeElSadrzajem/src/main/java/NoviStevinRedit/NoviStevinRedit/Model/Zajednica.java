package NoviStevinRedit.NoviStevinRedit.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "zajednice")
@Transactional
@ToString
public class Zajednica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idZajednice",nullable = false)
    private int idZajednice;


    @Column(name = "imeZajednice",nullable = false)
    private String imeZajednice;

    @Column(name = "opisZajednice",nullable = false)
    private String opisZajednice;

    @Column(name = "datumKreiranja",nullable = false)
    private LocalDate datumKreiranja;


    @Column(name = "suspendovana",nullable = false)
    private boolean suspendovana;


    @Column(name = "razlogSuspenzije")
    private RazlogPrijave razlogPrijave;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "zajednica")
    private Set<Objava> listaObjavi;

}
