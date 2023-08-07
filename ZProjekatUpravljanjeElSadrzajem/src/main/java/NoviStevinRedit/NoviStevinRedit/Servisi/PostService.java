package NoviStevinRedit.NoviStevinRedit.Servisi;

import NoviStevinRedit.NoviStevinRedit.DTO.PostDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.PostDTO2;
import NoviStevinRedit.NoviStevinRedit.Model.Objava;
import NoviStevinRedit.NoviStevinRedit.Model.Zajednica;

import java.util.List;

public interface PostService {

    public List<Objava>nadjiSveObjave();

    public List<PostDTO2> nadjiSveObjaveDTO();

    public List<Objava> nadjiSveObjaveJedneZajednice(int idZajednice);

    public List<PostDTO2> nadjiSveObjaveJedneZajednice2(int idZajednice);

    public Objava nadjiJednuObjavu(int idObjave);

    public PostDTO2 nadjiObjavu(int idObjave);

    public void obrisiObjavu(int idObjave);

    public Objava sacuvajObjavu(PostDTO objava);

    public Objava azurirajObjavu(PostDTO objavaDTO, int idObjave);

    public List<Objava> nadjiSveObjaveJednogKorisnika(String korisnickoIme);
}
