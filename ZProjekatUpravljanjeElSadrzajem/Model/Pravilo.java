package NoviStevinRedit.NoviStevinRedit.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor



@Entity
@Table(name = "pravila")
public class Pravilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPravila")
    private int idPravila;


    @Column(name = "opisPravila")
    private String opisPravila;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idZajednice" , referencedColumnName = "idZajednice", nullable = false)
    private Zajednica zajednica;
}
