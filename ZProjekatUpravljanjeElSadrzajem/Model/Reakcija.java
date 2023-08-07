package NoviStevinRedit.NoviStevinRedit.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "reakcije")
public class Reakcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReakcije")
    private int idReakcije;


    @Column(name = "tipReakcije",nullable = false)
    @Enumerated(EnumType.STRING)
    private TipReakcije tipReakcije;

    @Column(name = "vremeReakcije",nullable = false)
    private LocalDate vremeReakcije;


    @Column(name = "autorReakcije",nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "korisnickoIme")
    private Korisnik autorReakcije;


    @Column(name = "komentar")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idKomentara")
    private Komentar komentar;

    @Column(name = "objava")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idObjave")
    private Objava objava;



}
