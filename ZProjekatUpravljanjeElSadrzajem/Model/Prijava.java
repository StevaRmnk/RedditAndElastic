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
@Table(name = "prijave")
public class Prijava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrijave",unique = true,nullable = false)
    private Integer idPrijave;


    @Column(name = "razlogPrijave", nullable = false)
    @Enumerated(EnumType.STRING)
    private RazlogPrijave razlogPrijave;

    @Column(name = "datumPrijave", nullable = false)
    private LocalDate datumPrijave;


    @JoinColumn(name = "autor",referencedColumnName = "korisnickoIme", nullable = false)
    private Korisnik autor;

    @Column(name = "prihvacena",nullable = false)
    private boolean prihvacena;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idKomentara" , referencedColumnName = "idKomentara")
    private Komentar komentar;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idObjave" , referencedColumnName = "idObjave")
    private Objava objava;


}
