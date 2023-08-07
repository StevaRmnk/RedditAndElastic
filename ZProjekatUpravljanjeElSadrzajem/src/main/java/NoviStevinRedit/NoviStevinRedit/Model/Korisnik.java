package NoviStevinRedit.NoviStevinRedit.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "korisnici")
public class Korisnik {


    @Id
    @Column(name = "korisnickoIme",unique = true,nullable = false)
    private String korisnickoIme;

    @Column(name = "lozinka",nullable = false)
    private String lozinka;

    @Column(name = "e_mail",nullable = true)
    private String email;

    @Column(name = "avatar",nullable = false)
    private String avatar;

    @Column(name = "datumRegistracije",nullable = false)
    private LocalDate datumRegistracije;

    @Column(name = "opis",nullable = false)
    private String opis;

    @Column(name = "prikazanoIme",nullable = false)
    private String prikazanoIme;



}
