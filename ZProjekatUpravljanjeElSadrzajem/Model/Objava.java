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
@Table(name = "objave")
public class Objava {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idObjave",unique = true,nullable = false)
    private int idObjave;

    @Column(name = "naslovObjave",nullable = false)
    private String naslovObjave;


    @Column(name = "tekstObjave")
    private String tekstObjave;


    @Column(name = "datumKreiranja")
    private LocalDate datumKreiranja;


    @Column(name = "putanjaDoSlike")
    private String putanjaDoSlike;

    @JoinColumn(name = "autor", referencedColumnName = "korisnickoIme" , nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Korisnik autorObjave;


    @JoinColumn(name = "idFlaira", referencedColumnName = "idFlaira" , nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Flair flair;


}
