package NoviStevinRedit.NoviStevinRedit.Kontroleri;


import NoviStevinRedit.NoviStevinRedit.DTO.*;
import NoviStevinRedit.NoviStevinRedit.Model.Korisnik;
import NoviStevinRedit.NoviStevinRedit.Servisi.UserServis;
import NoviStevinRedit.NoviStevinRedit.Sigurnost.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserServis userServis;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;


    @GetMapping(value = "/")
    public ResponseEntity<List<Korisnik>> nadjiSveKorisnike(){
        return new ResponseEntity<>(userServis.nadjiSveKorisnike(),HttpStatus.FOUND);
    }

    @GetMapping(value = "/{korisnickoIme}")
    public ResponseEntity<Korisnik> nadjiJednogKorisnika(@PathVariable("korisnickoIme") String korisnickoIme){
        Korisnik nadjen = userServis.nadjiJednogKorisnika(korisnickoIme);
        return new ResponseEntity<>(nadjen,HttpStatus.OK);
    }


    @GetMapping(value = "/DTO/{korisnickoIme}")
    public ResponseEntity<UserPregledDTO> nadjiJednogKorisnikaDTO(@PathVariable("korisnickoIme") String korisnickoIme){
        UserPregledDTO nadjen = userServis.nadjiJednogKorisnikaDTO(korisnickoIme);
        return new ResponseEntity<>(nadjen,HttpStatus.OK);
    }


    @PostMapping(value = "/",consumes = "application/json")
    public ResponseEntity<Korisnik> sacuvajKorisnika(@RequestBody UserDTO userDTO){
        Korisnik noviKorisnik = userServis.kreirajKorisnika(userDTO);
        return new ResponseEntity<Korisnik>(noviKorisnik,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "delete/{korisnickoIme}")
    public  String obrisiKorisnika(@PathVariable("korisnickoIme")  String korisnickoIme){
        userServis.obrisiKorisnika(korisnickoIme);

        return "Obrisan korisnik sa korisnickim imenom: " + korisnickoIme;
    }


    @PutMapping(value = "/update/{korisnickoIme}", consumes = "application/json")
    public ResponseEntity<Korisnik> azurirajKorisnika(@PathVariable("korisnickoIme") String korisnickoIme, @RequestBody UserUpdateDTO userUpdateDTO){
    Korisnik azur =  userServis.azurirajKorisnika(userUpdateDTO,korisnickoIme);
     return new ResponseEntity<Korisnik>(azur,HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenDTO> createAuthenticationToken(
            @RequestBody JwtAuthRequestDTO authenticationRequest, HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user);
        int expiresIn = tokenUtils.getExpiredIn();

        return ResponseEntity.ok(new UserTokenDTO(jwt, expiresIn));
    }

    @PostMapping("/lozinka/{korisnickoIme}")
    public ResponseEntity<UserDTO>  promeniLozinku(@PathVariable("korisnickoIme") String korisnickoIme,@RequestBody IzmenaLozinkaDTO izmenaLozinkaDTO){
        Korisnik s = userServis.nadjiJednogKorisnika(korisnickoIme);
        Korisnik noviKorisnik = userServis.promeniLozinku(izmenaLozinkaDTO,korisnickoIme);
        UserDTO kr = new UserDTO();
        kr.setKorisnickoIme(korisnickoIme);
        kr.setEmail(s.getEmail());
        kr.setLozinka(noviKorisnik.getLozinka());
        return new ResponseEntity<>(kr,HttpStatus.OK);
    }


}
