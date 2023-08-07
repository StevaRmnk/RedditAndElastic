package NoviStevinRedit.NoviStevinRedit.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "objave")
@Transactional
@ToString
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
    @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik autorObjave;


    @JoinColumn(name = "idFlaira", referencedColumnName = "idFlaira")
    @ManyToOne(fetch = FetchType.EAGER)
    private Flair flair;

    @JsonBackReference
    @JoinColumn(name = "idZajednice", referencedColumnName = "idZajednice")
    @ManyToOne(fetch = FetchType.EAGER)
    private Zajednica zajednica;


}
