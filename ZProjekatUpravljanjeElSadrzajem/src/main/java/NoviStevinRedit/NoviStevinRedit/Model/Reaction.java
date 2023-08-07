package NoviStevinRedit.NoviStevinRedit.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Reakcije")
@Transactional
public class Reaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReakcije")
    private int idReakcije;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tipReakcije")
    private ReactionType tipReakcije;

    @Column(name = "datumReakcije")
    private LocalDate datumReakcije;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autorReakcije", referencedColumnName = "korisnickoIme", nullable = false)
    private Korisnik autorReakcije;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idObjave", referencedColumnName = "idObjave")
    private Objava objava;

}
