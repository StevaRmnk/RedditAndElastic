package NoviStevinRedit.NoviStevinRedit.Kontroleri;

import NoviStevinRedit.NoviStevinRedit.DTOElastic.ObjavaElDTO;
import NoviStevinRedit.NoviStevinRedit.ModelElastic.ObjavaEl;
import NoviStevinRedit.NoviStevinRedit.ServisiImplement.ObjaveServisElImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/objave")
public class ObjavaElastikController {

    @Autowired
    private ObjaveServisElImpl objaveServisEl;

    @GetMapping("/all")
    public ResponseEntity<List<ObjavaEl>> nadjiSveObjaveEl(){
        List<ObjavaEl> objave = objaveServisEl.nadjiObjave();
        return new ResponseEntity<>(objave, HttpStatus.OK);
    }

    @GetMapping("/naslov/{naslov}")
    public ResponseEntity<List<ObjavaEl>> nadjiObjavePoNaslovu(@PathVariable("naslov") String naslov){
        List<ObjavaEl> objave = objaveServisEl.nadjiObjavePoNaslovu(naslov);
        return new ResponseEntity<>(objave,HttpStatus.OK);
    }

    @GetMapping("/tekst/{tekst}")
    public ResponseEntity<List<ObjavaEl>> nadjiObjavePoTekstu(@PathVariable("tekst") String tekst){
        List<ObjavaEl> objave = objaveServisEl.nadjiObjavePoTekstu(tekst);
        return new ResponseEntity<>(objave,HttpStatus.OK);
    }

    @GetMapping("/pdfTekst/{pdfTekst}")
    public ResponseEntity<List<ObjavaEl>> nadjiObjavePoPDFu(@PathVariable("pdfTekst")String pdfTekst){
        List<ObjavaEl> objave = objaveServisEl.nadjiObjavePoTekstuPDFa(pdfTekst);
        return new ResponseEntity<>(objave,HttpStatus.OK);
    }

    @PostMapping(path = "/pdfObjave", consumes = {"multipart/form-data"})
    @CrossOrigin
    public void uploadPDF(@ModelAttribute ObjavaElDTO objavaElDTO) throws IOException {
        objaveServisEl.sacuvajUploadovaniFajl(objavaElDTO);
    }

    @PostMapping(value = "/dodaj")
    @CrossOrigin
    public ResponseEntity<ObjavaEl> dodajNovuObjavu(@RequestBody ObjavaEl objavaEl){

        objaveServisEl.sacuvajObjavu(objavaEl);

        return new ResponseEntity<>(objavaEl,HttpStatus.CREATED);
    }


}
