package NoviStevinRedit.NoviStevinRedit.Kontroleri;

import NoviStevinRedit.NoviStevinRedit.DTO.KomentarDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Komentar;
import NoviStevinRedit.NoviStevinRedit.Servisi.KomentarServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("komentari")
public class KomentarController {

    @Autowired
    private KomentarServis komentarServis;

    @GetMapping(value = "/{idObjave}")
    public ResponseEntity<List<KomentarDTO>> nadjiKomentareJedneObjave(@PathVariable("idObjave") int idObjave){
        List<KomentarDTO> komentari = komentarServis.nadjiSveKomentareJedneObjave(idObjave);
        return new ResponseEntity<>(komentari, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<KomentarDTO> sacuvajKomentar(@RequestBody KomentarDTO komentarDTO){
        KomentarDTO kom = new KomentarDTO();
        Komentar sa = komentarServis.sacuvajKomentar(komentarDTO);
        kom.setIdKomentara(sa.getIdKomentara());
        kom.setTekstKomentara(sa.getTekstKomentara());
        kom.setObjava(sa.getObjava().getIdObjave());
        kom.setObrisan(sa.isObrisan());
        kom.setDatumKreiranjaKomentara(sa.getDatumKreiranjaKomentara().toString());
        kom.setAutorKomentara(sa.getAutorKomentara().getKorisnickoIme());
        return new ResponseEntity<>(kom,HttpStatus.CREATED);
    }
}
