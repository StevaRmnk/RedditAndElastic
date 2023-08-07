package NoviStevinRedit.NoviStevinRedit.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "komentari")
public class Komentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idKomentara",nullable = false)
    private int idKomentara;

    @Column(name = "tekstKomentara",nullable = false)
    private String tekstKomentara;

    @Column(name = "datumKreiranjaKomentara",nullable = false)
    private LocalDate datumKreiranjaKomentara;

    @ManyToOne
    @JoinColumn(name = "autorKomentara",referencedColumnName = "korisnickoIme",nullable = false)
    private Korisnik autorKomentara;

    @ManyToOne
    @JoinColumn(name = "idObjave",referencedColumnName = "idObjave",nullable = false)
    private Objava objava;

    @Column(name = "obrisan",nullable = false)
    private boolean obrisan;

}
