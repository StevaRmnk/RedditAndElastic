package NoviStevinRedit.NoviStevinRedit.Servisi;

import NoviStevinRedit.NoviStevinRedit.DTO.IzmenaLozinkaDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.UserDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.UserPregledDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.UserUpdateDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Korisnik;

import java.util.List;

public interface UserServis {

    public List<Korisnik> nadjiSveKorisnike();

    public Korisnik nadjiJednogKorisnika(String korisnickoIme);

    public UserPregledDTO nadjiJednogKorisnikaDTO(String korisnickoIme);


    public void obrisiKorisnika(String korisnickoIme);

    public Korisnik kreirajKorisnika(UserDTO userDTO);

    public Korisnik azurirajKorisnika(UserUpdateDTO userUpdateDTO,String korisnickoIme);

    public int nadjiKarmuKorisnika(String korisnickoIme);

    public Korisnik promeniLozinku(IzmenaLozinkaDTO izmenaLozinkaDTO, String korisnickoIme);
}
