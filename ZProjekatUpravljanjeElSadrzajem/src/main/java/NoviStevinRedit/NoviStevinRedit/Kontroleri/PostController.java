package NoviStevinRedit.NoviStevinRedit.Kontroleri;

import NoviStevinRedit.NoviStevinRedit.DTO.PostDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.PostDTO2;
import NoviStevinRedit.NoviStevinRedit.Model.Objava;
import NoviStevinRedit.NoviStevinRedit.Servisi.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    PostService postService;


    @GetMapping(value = "/")
    public ResponseEntity<List<Objava>> nadjiSveObjave(){
        return new ResponseEntity<List<Objava>>(postService.nadjiSveObjave(), HttpStatus.OK);
    }


    @GetMapping(value = "/DTO")
    public ResponseEntity<List<PostDTO2>> nadjiSveObjaveDTO(){
        return new ResponseEntity<List<PostDTO2>>(postService.nadjiSveObjaveDTO(), HttpStatus.OK);
    }

    @GetMapping(value = "/post/{id}")
    public ResponseEntity<PostDTO2> nadjiObj(@PathVariable("id") int idObjave){
        PostDTO2 tr = postService.nadjiObjavu(idObjave);
        return new ResponseEntity<>(tr,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Objava> nadjiJednuObjavu(@PathVariable ("id") int idObjave){
        Objava nadjena = postService.nadjiJednuObjavu(idObjave);
        return new ResponseEntity<>(nadjena,HttpStatus.OK);
    }

    @PostMapping(value = "/" ,consumes = "application/json")
    public ResponseEntity<PostDTO> napraviObjavu(@RequestBody PostDTO postDTO){
        Objava novaObjava = postService.sacuvajObjavu(postDTO);
        PostDTO dto = new PostDTO();
        dto.setTekstObjave(novaObjava.getTekstObjave());
        dto.setNaslovObjave(novaObjava.getNaslovObjave());
        dto.setAutorObjave(novaObjava.getAutorObjave().getKorisnickoIme());
        dto.setZajednica(novaObjava.getZajednica().getIdZajednice());
        dto.setPutanjaDoSlike(novaObjava.getPutanjaDoSlike());
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }



    @GetMapping(value = "/idZajednice/{idZajednice}")
    public ResponseEntity<List<Objava>> nadjiObjaveZajednice(@PathVariable("idZajednice") int idZajednice){
        List<Objava> sveObjave = postService.nadjiSveObjaveJedneZajednice(idZajednice);
        return new ResponseEntity<List<Objava>>(sveObjave,HttpStatus.OK);
    }

    @GetMapping(value = "/idZajednice2/{idZajednice}")
    public ResponseEntity<List<PostDTO2>> nadjiObjaveZajednice2(@PathVariable("idZajednice") int idZajednice){
        List<PostDTO2> sveObjave = postService.nadjiSveObjaveJedneZajednice2(idZajednice);
        return new ResponseEntity<>(sveObjave,HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Integer> obrisiObjavu(@PathVariable ("id") int idObjave){
        Objava bja = postService.nadjiJednuObjavu(idObjave);
        System.out.println("OVO JE OBJAVA KOJU BRISES!" + bja.getIdObjave());
        postService.obrisiObjavu(idObjave);
        return new ResponseEntity<>(bja.getIdObjave(),HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<Objava> azurirajObjavu(@PathVariable ("id") int idObjave,@RequestBody PostDTO postDTO){
        Objava objavaZaIzmenu = postService.azurirajObjavu(postDTO,idObjave);
        return new ResponseEntity<>(objavaZaIzmenu,HttpStatus.OK);

    }

}
