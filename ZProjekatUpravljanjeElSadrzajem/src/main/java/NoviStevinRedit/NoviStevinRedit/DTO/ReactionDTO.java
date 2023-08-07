package NoviStevinRedit.NoviStevinRedit.DTO;

import NoviStevinRedit.NoviStevinRedit.Model.Korisnik;
import NoviStevinRedit.NoviStevinRedit.Model.Objava;
import NoviStevinRedit.NoviStevinRedit.Model.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReactionDTO {

    private ReactionType tipReakcije;

    private String autorReakcije;

    private int idObjave;

}
