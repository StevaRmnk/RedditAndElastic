package NoviStevinRedit.NoviStevinRedit.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Moderator {

    @Column
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Zajednica> listaZajednica;

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik korisnik;

}