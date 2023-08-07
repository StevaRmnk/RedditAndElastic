package NoviStevinRedit.NoviStevinRedit.DTO;

import NoviStevinRedit.NoviStevinRedit.Model.Korisnik;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {


    private String korisnickoIme;


    private String lozinka;


    private String email;



    public UserDTO(Korisnik korisnik){
        this(korisnik.getKorisnickoIme(), korisnik.getLozinka(), korisnik.getEmail());

    }


}
