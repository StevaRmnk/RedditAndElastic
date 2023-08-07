package NoviStevinRedit.NoviStevinRedit.DTO;



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

public class KomentarDTO {

    private int idKomentara;


    private String tekstKomentara;


    private String datumKreiranjaKomentara;


    private String autorKomentara;


    private int objava;


    private boolean obrisan;


}
