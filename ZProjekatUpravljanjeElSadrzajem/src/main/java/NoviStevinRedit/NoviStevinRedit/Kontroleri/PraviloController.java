package NoviStevinRedit.NoviStevinRedit.Kontroleri;

import NoviStevinRedit.NoviStevinRedit.DTO.RuleDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.RuleDTO2;
import NoviStevinRedit.NoviStevinRedit.Model.Pravilo;
import NoviStevinRedit.NoviStevinRedit.Servisi.PraviloServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pravila")
public class PraviloController {

    @Autowired
    PraviloServis praviloServis;

    @GetMapping(value = "/{idZajednice}")
    public ResponseEntity<List<RuleDTO2>> nadjiSvaPravilaZajednice(@PathVariable("idZajednice") int idZajednice){
        List<Pravilo> zaje = praviloServis.nadjiSvaPravilaJedneZajednice(idZajednice);
        List<RuleDTO2> zajednice = new ArrayList<>();
        for (Pravilo  p : zaje){
            RuleDTO2 pravilo = new RuleDTO2();
            pravilo.setIdPravila(p.getIdPravila());
            pravilo.setOpisPravila(p.getOpisPravila());
            pravilo.setZajednica(p.getZajednica().getIdZajednice());

            zajednice.add(pravilo);
        }
        return new ResponseEntity<>(zajednice, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<RuleDTO2> napraviPravilo(@RequestBody RuleDTO ruleDTO){
        Pravilo pravilo = praviloServis.napraviPravilo(ruleDTO);
        RuleDTO2 s = new RuleDTO2();
        s.setIdPravila(pravilo.getIdPravila());
        s.setOpisPravila(pravilo.getOpisPravila());
        s.setZajednica(pravilo.getZajednica().getIdZajednice());
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }
}
