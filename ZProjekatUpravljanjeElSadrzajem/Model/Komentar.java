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
@Table(name = "komentari")
public class Komentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKomentara",unique = true,nullable = false)
    private int idKomentara;


    @Column(name = "tekstKomentara",nullable = false)
    private String tekstKomentara;


    @Column(name = "datumPostavljanja",nullable = false)
    private LocalDate datumPostavljanja;


    @Column(name = "obrisan",nullable = false)
    private boolean obrisan;

    @JoinColumn(name = "autorKomentara", referencedColumnName = "korisnickoIme",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Korisnik autorKomentara;


    @JoinColumn(name = "idObjave", referencedColumnName = "idObjave",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Objava objava;


    @Column(name = "odgovoriNaKomentar")
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Komentar> odgovoriNaKomentar;

}
