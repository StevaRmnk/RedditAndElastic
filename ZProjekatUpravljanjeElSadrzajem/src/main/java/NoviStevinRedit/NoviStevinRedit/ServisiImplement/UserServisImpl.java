package NoviStevinRedit.NoviStevinRedit.ServisiImplement;

import NoviStevinRedit.NoviStevinRedit.DTO.IzmenaLozinkaDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.UserDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.UserPregledDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.UserUpdateDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Korisnik;
import NoviStevinRedit.NoviStevinRedit.Model.Objava;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.UsersRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Servisi.PostService;
import NoviStevinRedit.NoviStevinRedit.Servisi.ReactionServis;
import NoviStevinRedit.NoviStevinRedit.Servisi.UserServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServisImpl implements UserServis {

    @Autowired
    private UsersRepozitorijum usersRepozitorijum;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PostService postServis;

    @Autowired
    private ReactionServis reactionServis;



    @Override
    public List<Korisnik> nadjiSveKorisnike() {
        return usersRepozitorijum.findAll();
    }

    @Override
    public Korisnik nadjiJednogKorisnika(String korisnickoIme) {
        return usersRepozitorijum.findById(korisnickoIme).orElseGet(null);
    }

    @Override
    public UserPregledDTO nadjiJednogKorisnikaDTO(String korisnickoIme) {

        Korisnik kor = usersRepozitorijum.findById(korisnickoIme).orElseGet(null);
        UserPregledDTO korisnik = new UserPregledDTO();

        korisnik.setKorisnickoIme(kor.getKorisnickoIme());
        korisnik.setOpis(kor.getOpis());
        korisnik.setDatumRegistracije(kor.getDatumRegistracije().toString());
        korisnik.setEmail(kor.getEmail());


        return korisnik;
    }


    @Override
    public void obrisiKorisnika(String korisnickoIme) {
        usersRepozitorijum.deleteById(korisnickoIme);
    }

    @Override
    public Korisnik kreirajKorisnika(UserDTO userDTO) {

        List<Korisnik> sviKorisnici = usersRepozitorijum.findAll();

        Korisnik noviKorisnik = new Korisnik();
        noviKorisnik.setLozinka(passwordEncoder.encode(userDTO.getLozinka()));
        noviKorisnik.setEmail(userDTO.getEmail());
        noviKorisnik.setAvatar("avatar");
        noviKorisnik.setDatumRegistracije(LocalDate.now());
        noviKorisnik.setOpis("Opis");
        noviKorisnik.setPrikazanoIme(userDTO.getKorisnickoIme());
        for (Korisnik jedan : sviKorisnici){
            if (jedan.getKorisnickoIme().equals(userDTO.getKorisnickoIme())){
                System.out.println("Postoji korisnik sa tim korisnickim imenom!");
            }

        }
        noviKorisnik.setKorisnickoIme(userDTO.getKorisnickoIme());
        usersRepozitorijum.save(noviKorisnik);
        return noviKorisnik;
    }

    @Override
    public Korisnik azurirajKorisnika(UserUpdateDTO userUpdateDTO,String korisnickoIme) {

        Korisnik azuriraniKorisnik = usersRepozitorijum.findById(korisnickoIme).orElseGet(null);

        if(userUpdateDTO.getOpis() !=null){
            azuriraniKorisnik.setOpis(userUpdateDTO.getOpis());
        }
        if(userUpdateDTO.getEmail() !=null) {
            azuriraniKorisnik.setEmail(userUpdateDTO.getEmail());
        }

        usersRepozitorijum.save(azuriraniKorisnik);
        return azuriraniKorisnik;
    }

    @Override
    public int nadjiKarmuKorisnika(String korisnickoIme) {
        int karmaKorisnika = 0;
        List<Objava> sveObjaveKorisnika = postServis.nadjiSveObjaveJednogKorisnika(korisnickoIme);
        for(Objava jedna : sveObjaveKorisnika){
            karmaKorisnika += reactionServis.nadjiKarmuObjave(jedna.getIdObjave());
        }
        return karmaKorisnika;
    }

    @Override
    public Korisnik promeniLozinku(IzmenaLozinkaDTO izmenaLozinkaDTO, String korisnickoIme) {

        Korisnik korisnik = usersRepozitorijum.findById(korisnickoIme).orElseGet(null);
        String p = passwordEncoder.encode(izmenaLozinkaDTO.lozinka);
        korisnik.setLozinka(p);
        usersRepozitorijum.save(korisnik);

        return korisnik;
    }
}
