package NoviStevinRedit.NoviStevinRedit.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class UserWithPasswordDTO {

    private String korisnickoIme;
    private String email;
    private String opis;
    private String datumRegistracije;
    private String lozinka;

}
