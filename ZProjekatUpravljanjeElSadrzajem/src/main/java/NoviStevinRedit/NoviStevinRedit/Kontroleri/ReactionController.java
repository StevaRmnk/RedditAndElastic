package NoviStevinRedit.NoviStevinRedit.Kontroleri;

import NoviStevinRedit.NoviStevinRedit.DTO.ReactionDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.ReactionDTO2;
import NoviStevinRedit.NoviStevinRedit.Model.Reaction;
import NoviStevinRedit.NoviStevinRedit.Servisi.ReactionServis;
import NoviStevinRedit.NoviStevinRedit.Servisi.UserServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reactions")
public class ReactionController {

    @Autowired
    public ReactionServis reactionServis;

    @Autowired
    public UserServis userServis;


    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<ReactionDTO2> napraviReakciju(@RequestBody ReactionDTO reactionDTO){
        System.out.println(reactionDTO.getIdObjave());
        Reaction novaReakcija = reactionServis.sacuvajReakciju(reactionDTO);
        ReactionDTO2 rd = new ReactionDTO2();
        rd.setIdReakcije(novaReakcija.getIdReakcije());
        rd.setDatumReakcije(novaReakcija.getDatumReakcije().toString());
        rd.setAutorReakcije(novaReakcija.getAutorReakcije().getKorisnickoIme());
        rd.setObjava(novaReakcija.getObjava().getIdObjave());
        rd.setTipReakcije(novaReakcija.getTipReakcije().toString());
        return new ResponseEntity<>(rd, HttpStatus.CREATED);
    }

    @GetMapping(value = "/karma/{idObjave}")
    public  ResponseEntity<Integer> nadjiKarmu(@PathVariable("idObjave") int idObjave){
        int karma = reactionServis.nadjiKarmuObjave(idObjave);
        return new ResponseEntity<Integer>(karma,HttpStatus.OK);
    }

    @GetMapping(value = "/karmaKor/{korisnickoIme}")
    public ResponseEntity<Integer> nadjiKarmuKorisnika(@PathVariable("korisnickoIme") String korisnickoIme){
        int karmaKorisnika = userServis.nadjiKarmuKorisnika(korisnickoIme);
        System.out.println("Ovo je karma korissnika" + karmaKorisnika);
        return new ResponseEntity<Integer>(karmaKorisnika,HttpStatus.OK);
    }

}
