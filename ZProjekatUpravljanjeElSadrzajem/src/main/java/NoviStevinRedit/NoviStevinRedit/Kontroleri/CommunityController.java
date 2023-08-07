package NoviStevinRedit.NoviStevinRedit.Kontroleri;

import NoviStevinRedit.NoviStevinRedit.DTO.CommunityDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.CommunityGETDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Zajednica;
import NoviStevinRedit.NoviStevinRedit.Servisi.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("communities")
public class CommunityController {

    @Autowired
    CommunityService communityService;



    @GetMapping(value = "/")
    public ResponseEntity<List<Zajednica>> nadjiSveZajednice(){
        return new ResponseEntity<>(communityService.nadjiSveZajednice(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Zajednica> nadjiJednuZajednicu(@PathVariable ("id") int idZajednice){
        Zajednica nadjena = communityService.nadjiJednuZajednicu(idZajednice);
        return new ResponseEntity<>(nadjena,HttpStatus.OK);
    }

    @GetMapping("/DTO")
    public ResponseEntity<List<CommunityGETDTO>> nadjiZajednice(){
     return new ResponseEntity<>(communityService.nadjiZajednice(),HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<CommunityDTO> sacuvajZajednicu(@RequestBody CommunityDTO communityDTO){
        Zajednica novaZajednica = communityService.sacuvajZajednicu(communityDTO);
        CommunityDTO community = new CommunityDTO();
        community.setImeZajednice(novaZajednica.getImeZajednice());
        community.setOpisZajednice(novaZajednica.getOpisZajednice());
        return new ResponseEntity<>(community,HttpStatus.CREATED);
    }


    @DeleteMapping(value = "delete/{id}")
    public String obrisiZajednicu(@PathVariable ("id") int idZajednice){
        communityService.obrisiZajednicu(idZajednice);
        return  "Obrisana zajednica sa identifikatorom: " + idZajednice;
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Zajednica> azurirajZajednicu(@PathVariable ("id") int idZajednice, @RequestBody CommunityDTO communityDTO){
        Zajednica zaIzmenu = communityService.azurirajZajednicu(communityDTO,idZajednice);
        return new ResponseEntity<Zajednica>(zaIzmenu,HttpStatus.OK);

    }




}
