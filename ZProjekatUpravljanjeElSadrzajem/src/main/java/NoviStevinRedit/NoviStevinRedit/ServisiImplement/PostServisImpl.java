package NoviStevinRedit.NoviStevinRedit.ServisiImplement;

import NoviStevinRedit.NoviStevinRedit.DTO.PostDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.PostDTO2;
import NoviStevinRedit.NoviStevinRedit.Model.*;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.CommunitiesRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.PostsRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.ReactionRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.UsersRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Servisi.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServisImpl implements PostService {

    @Autowired
    private PostsRepozitorijum postsRepozitorijum;

    @Autowired
    private UsersRepozitorijum usersRepozitorijum;

    @Autowired
    private CommunitiesRepozitorijum communitiesRepozitorijum;

    @Autowired
    private ReactionRepozitorijum reactionRepozitorijum;

    @Override
    public List<Objava> nadjiSveObjave() {
        return postsRepozitorijum.findAll();
    }

    @Override
    public List<PostDTO2> nadjiSveObjaveDTO() {

        List<PostDTO2> sveObjaveDTO = new ArrayList<>();
        List<Objava> sveObjave = nadjiSveObjave();


        for(Objava jedna : sveObjave){
            PostDTO2 postDTO = new PostDTO2();
            postDTO.setIdObjave(jedna.getIdObjave());
            postDTO.setPutanjaDoSlike(jedna.getPutanjaDoSlike());
            postDTO.setNaslovObjave(jedna.getNaslovObjave());
            postDTO.setTekstObjave(jedna.getTekstObjave());
            postDTO.setZajednica(jedna.getZajednica().getImeZajednice());
            postDTO.setDatumKreiranja(jedna.getDatumKreiranja().toString());
            postDTO.setAutorObjave(jedna.getAutorObjave().getKorisnickoIme());

            sveObjaveDTO.add(postDTO);
        }

        return sveObjaveDTO;
    }


    @Override
    public List<Objava> nadjiSveObjaveJedneZajednice(int idZajednice) {
        return postsRepozitorijum.nadjiSveObjaveJedneZajednice(idZajednice);
    }

    @Override
    public List<PostDTO2> nadjiSveObjaveJedneZajednice2(int idZajednice) {

        List<Objava> nad = nadjiSveObjaveJedneZajednice(idZajednice);
        List<PostDTO2> nadjene = new ArrayList<>();

        for (Objava jedna : nad){
            PostDTO2 sa = new PostDTO2();
            sa.setIdObjave(jedna.getIdObjave());
            sa.setNaslovObjave(jedna.getNaslovObjave());
            sa.setTekstObjave(jedna.getTekstObjave());
            sa.setZajednica(jedna.getZajednica().getImeZajednice());
            sa.setAutorObjave(jedna.getAutorObjave().getKorisnickoIme());
            sa.setDatumKreiranja(jedna.getDatumKreiranja().toString());
            sa.setPutanjaDoSlike(jedna.getPutanjaDoSlike());
            nadjene.add(sa);
        }

        return nadjene;
    }


    @Override
    public Objava nadjiJednuObjavu(int idObjave) {
        return postsRepozitorijum.findById(idObjave).orElseGet(null);
    }

    @Override
    public PostDTO2 nadjiObjavu(int idObjave) {

        PostDTO2 trazena = new PostDTO2();
        Objava nadj = nadjiJednuObjavu(idObjave);
        trazena.setNaslovObjave(nadj.getNaslovObjave());
        trazena.setZajednica(nadj.getZajednica().getImeZajednice());
        trazena.setAutorObjave(nadj.getAutorObjave().getKorisnickoIme());
        trazena.setIdObjave(nadj.getIdObjave());
        trazena.setTekstObjave(nadj.getTekstObjave());
        trazena.setDatumKreiranja(nadj.getDatumKreiranja().toString());
        trazena.setPutanjaDoSlike(nadj.getPutanjaDoSlike());

        return trazena;
    }


    @Override
    public void obrisiObjavu(int idObjave) {
        reactionRepozitorijum.ObrisiSveReakcijeZaJednuObjavu(idObjave);
        postsRepozitorijum.deleteById(idObjave);
    }

    @Override
    public Objava sacuvajObjavu(PostDTO objavaDTO) {

        Zajednica zaj = communitiesRepozitorijum.findById(objavaDTO.getZajednica()).orElseGet(null);
        Korisnik autor = usersRepozitorijum.findById(objavaDTO.getAutorObjave()).orElseGet(null);


        Objava novaObjava = new Objava();


        novaObjava.setNaslovObjave(objavaDTO.getNaslovObjave());
        novaObjava.setTekstObjave(objavaDTO.getTekstObjave());
        novaObjava.setPutanjaDoSlike(objavaDTO.getPutanjaDoSlike());
        novaObjava.setDatumKreiranja(LocalDate.now());
        novaObjava.setZajednica(zaj);
        novaObjava.setAutorObjave(autor);
        novaObjava.setFlair(null);

        postsRepozitorijum.save(novaObjava);

        Reaction novaReakcija = new Reaction();
        novaReakcija.setAutorReakcije(novaObjava.getAutorObjave());
        novaReakcija.setObjava(novaObjava);
        novaReakcija.setDatumReakcije(LocalDate.now());
        novaReakcija.setTipReakcije(ReactionType.UPVOTE);

        reactionRepozitorijum.save(novaReakcija);

        return novaObjava;
    }

    @Override
    public Objava azurirajObjavu(PostDTO postDTO, int idObjave) {

        Objava nadjena =  nadjiJednuObjavu(idObjave);

        if(postDTO.getNaslovObjave()!= null){
            nadjena.setNaslovObjave(postDTO.getNaslovObjave());
        }
        if(postDTO.getTekstObjave()!= null){
            nadjena.setTekstObjave(postDTO.getTekstObjave());
        }
        if (postDTO.getPutanjaDoSlike()!= null){
            nadjena.setPutanjaDoSlike(postDTO.getPutanjaDoSlike());
        }
        postsRepozitorijum.save(nadjena);

        return nadjena;
    }

    @Override
    public List<Objava> nadjiSveObjaveJednogKorisnika(String korisnickoIme) {
        return postsRepozitorijum.nadjiSveObjaveJednogKorisnika(korisnickoIme);
    }


}
