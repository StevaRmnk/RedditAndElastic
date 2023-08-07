package NoviStevinRedit.NoviStevinRedit.Kontroleri;



import NoviStevinRedit.NoviStevinRedit.DTOElastic.ZajednicaElDTO;
import NoviStevinRedit.NoviStevinRedit.ModelElastic.ZajednicaEl;
import NoviStevinRedit.NoviStevinRedit.ServisiImplement.ZajedniceServisElImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/zajednice")
public class ZajednicaElastikController {

    @Autowired
    private ZajedniceServisElImpl zajedniceServisEl;
//
//    @Autowired
//    private ZajedniceServisEl zajedniceServisEl;
//
    @GetMapping("/all")
    public ResponseEntity<List<ZajednicaEl>> nadjiSveZajednice(){
        List<ZajednicaEl> zajednice = zajedniceServisEl.nadjiSveZajednice();
        return new ResponseEntity<>(zajednice, HttpStatus.OK);
    }

    @GetMapping("/naziv/{naziv}")
    public ResponseEntity<List<ZajednicaEl>> nadjiZajednicePoNazivu(@PathVariable("naziv") String naziv){
        List<ZajednicaEl> zajednice = zajedniceServisEl.nadjiZajednicePoNazivu(naziv);
        return new ResponseEntity<>(zajednice, HttpStatus.OK);
    }
    @GetMapping("/opis/{opis}")
    public ResponseEntity<List<ZajednicaEl>> nadjiZajednicePoOpisu(@PathVariable("opis") String opis){
        List<ZajednicaEl> zajednice = zajedniceServisEl.nadjiZajednicePoOpisu(opis);
        return new ResponseEntity<>(zajednice,HttpStatus.OK);
    }

    @GetMapping("/pdfOpis/{pdfOpis}")
    public ResponseEntity<List<ZajednicaEl>>  nadjiZajednicePoPdf(@PathVariable("pdfOpis")String opisPdf){
        List<ZajednicaEl> zajednice = zajedniceServisEl.nadjiZajednicePoOpisuPDF(opisPdf);
        return new ResponseEntity<>(zajednice,HttpStatus.OK);
    }

    @PostMapping(path = "/pdf", consumes={"multipart/form-data"})
    @CrossOrigin
    public void uploadPDF(@ModelAttribute ZajednicaElDTO zajednicaElDTO) throws IOException{
        zajedniceServisEl.sacuvajUploadovanFajl(zajednicaElDTO);
    }

    @PostMapping(value = "/dodaj")
    @CrossOrigin
    public ResponseEntity<ZajednicaEl> dodajZajednicu(@RequestBody ZajednicaEl zajednicaEl){

        zajedniceServisEl.sacuvajZajednicuElastik(zajednicaEl);
        return new ResponseEntity<>(zajednicaEl,HttpStatus.CREATED);
    }
}
