package NoviStevinRedit.NoviStevinRedit.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "zajednice")
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


    @Column(name = "razlogSuspenzije",nullable = false)
    private RazlogPrijave razlogPrijave;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idObjave",referencedColumnName = "idObjave")
    private Set<Objava> listaObjavi;
}
