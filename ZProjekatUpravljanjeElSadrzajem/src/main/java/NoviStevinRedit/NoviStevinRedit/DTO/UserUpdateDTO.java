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

public class UserUpdateDTO {


    private String email;


    private String opis;

}
