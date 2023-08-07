package NoviStevinRedit.NoviStevinRedit.ServisiImplement;

import NoviStevinRedit.NoviStevinRedit.DTO.ReactionDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Korisnik;
import NoviStevinRedit.NoviStevinRedit.Model.Objava;
import NoviStevinRedit.NoviStevinRedit.Model.Reaction;
import NoviStevinRedit.NoviStevinRedit.Model.ReactionType;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.PostsRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.ReactionRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.UsersRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Servisi.ReactionServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ReactionServisImpl implements ReactionServis {

    @Autowired
    private PostsRepozitorijum postsRepozitorijum;

    @Autowired
    private ReactionRepozitorijum reactionRepozitorijum;

    @Autowired
    private UsersRepozitorijum usersRepozitorijum;

    @Override
    public List<Reaction> nadjiSveReakcijeZaJednuObjavu(int idObjave) {
        return reactionRepozitorijum.nadjiSveReakcijeZaJednuObjavu(idObjave);
    }

    @Override
    public List<Reaction> nadjiSveReakcije() {
        return reactionRepozitorijum.findAll();
    }

    @Override
    public Reaction sacuvajReakciju(ReactionDTO reakcija) {

        List<Reaction> sveReakcije = nadjiSveReakcije();

        int idobj = reakcija.getIdObjave();
        System.out.println("Ovo je idobj"+idobj);


        Korisnik korisnik = usersRepozitorijum.findById(reakcija.getAutorReakcije()).orElseGet(null);
        Objava obj = postsRepozitorijum.findById(idobj).orElseGet(null);

        Reaction novaReakcija = new Reaction();
        novaReakcija.setAutorReakcije(korisnik);
        novaReakcija.setTipReakcije(reakcija.getTipReakcije());
        novaReakcija.setObjava(obj);
        novaReakcija.setDatumReakcije(LocalDate.now());

        boolean postoji = false;
        boolean zaIzmenu = false;
        Reaction reakcijaZaIzmenu = new Reaction();

        for(Reaction reak : sveReakcije){
            if(reak.getAutorReakcije().getKorisnickoIme().equals(novaReakcija.getAutorReakcije().getKorisnickoIme()) && reak.getObjava().getIdObjave() == novaReakcija.getObjava().getIdObjave() && reak.getTipReakcije().equals(novaReakcija.getTipReakcije())){
                postoji = true;
                break;

            }
            if(reak.getAutorReakcije().getKorisnickoIme().equals(novaReakcija.getAutorReakcije().getKorisnickoIme()) && reak.getObjava().getIdObjave() == novaReakcija.getObjava().getIdObjave()){
                zaIzmenu = true;
                reakcijaZaIzmenu = reak;

            }
        }


        if (postoji){
            System.out.println("Postoji vec takva reakcija!");
        }
        else if(zaIzmenu){
            if(reakcijaZaIzmenu.getTipReakcije().equals(ReactionType.DOWNVOTE)){
                reactionRepozitorijum.izmeniTipReakcije("UPVOTE",reakcijaZaIzmenu.getIdReakcije());
            }
            if(reakcijaZaIzmenu.getTipReakcije().equals(ReactionType.UPVOTE)){
                reactionRepozitorijum.izmeniTipReakcije("DOWNVOTE",reakcijaZaIzmenu.getIdReakcije());
            }
        }
        else {
            reactionRepozitorijum.save(novaReakcija);
        }
        return novaReakcija;

    }

    @Override
    public void obrisisveReakcijezaJednuObjavu(int idObjave) {
        reactionRepozitorijum.ObrisiSveReakcijeZaJednuObjavu(idObjave);
    }

    @Override
    public int nadjiKarmuObjave(int idObjave) {

        int karma = 0;

        List<Reaction> sveReakcije = reactionRepozitorijum.nadjiSveReakcijeZaJednuObjavu(idObjave);
        for(Reaction jedna : sveReakcije){
            if(jedna.getTipReakcije().equals(ReactionType.UPVOTE)){
                karma += 1;
            }
            if(jedna.getTipReakcije().equals(ReactionType.DOWNVOTE)){
                karma -= 1;
            }
        }
        return karma;
    }


}
