package NoviStevinRedit.NoviStevinRedit.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



@Entity
@Table(name = "flairovi")
public class Flair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFlaira",unique = true,nullable = false)
    private int idFlaira;


    @Column(name = "ime")
    private String ime;

    @Column(name = "listaZajednica")
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Zajednica> listaZajednica;
}
