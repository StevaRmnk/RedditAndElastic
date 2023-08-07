package NoviStevinRedit.NoviStevinRedit.ServisiImplement;

import NoviStevinRedit.NoviStevinRedit.DTO.KomentarDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Komentar;
import NoviStevinRedit.NoviStevinRedit.Model.Korisnik;
import NoviStevinRedit.NoviStevinRedit.Model.Objava;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.KomentariRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.PostsRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.UsersRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Servisi.KomentarServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class KomentarServisImpl implements KomentarServis {

    @Autowired
    private KomentariRepozitorijum komentariRepozitorijum;

    @Autowired
    private PostsRepozitorijum postsRepozitorijum;

    @Autowired
    private UsersRepozitorijum usersRepozitorijum;

    @Override
    public List<Komentar> nadjiSveKomentare() {
        return komentariRepozitorijum.findAll();
    }

    @Override
    public List<KomentarDTO> nadjiSveKomentareDTO() {
        List<Komentar> komentari = komentariRepozitorijum.findAll();
        List<KomentarDTO> kome = new ArrayList<>();
        for (Komentar k : komentari){
            KomentarDTO nov = new KomentarDTO();
            nov.setIdKomentara(k.getIdKomentara());
            nov.setDatumKreiranjaKomentara(k.getDatumKreiranjaKomentara().toString());
            nov.setTekstKomentara(k.getTekstKomentara());
            nov.setAutorKomentara(k.getAutorKomentara().getKorisnickoIme());
            nov.setObrisan(k.isObrisan());
            nov.setObjava(k.getObjava().getIdObjave());

            kome.add(nov);
        }
        return kome;
    }

    @Override
    public Komentar nadjiJedanKomentar(int idKomentara) {
        return komentariRepozitorijum.findById(idKomentara).orElseGet(null);
    }

    @Override
    public KomentarDTO nadjiJedanKomentarDTO(int idKomentara) {
        Komentar lp = komentariRepozitorijum.findById(idKomentara).orElseGet(null);
        KomentarDTO komentar = new KomentarDTO();
        komentar.setIdKomentara(lp.getIdKomentara());
        komentar.setDatumKreiranjaKomentara(lp.getDatumKreiranjaKomentara().toString());
        komentar.setObrisan(lp.isObrisan());
        komentar.setTekstKomentara(lp.getTekstKomentara());
        komentar.setAutorKomentara(lp.getAutorKomentara().getKorisnickoIme());
        komentar.setObjava(lp.getObjava().getIdObjave());
        return komentar;
    }

    @Override
    public Komentar sacuvajKomentar(KomentarDTO komentarDTO) {
        Komentar zaUpisivanje = new Komentar();
        Objava objava = postsRepozitorijum.findById(komentarDTO.getObjava()).orElseGet(null);
        Korisnik autor = usersRepozitorijum.findById(komentarDTO.getAutorKomentara()).orElseGet(null);

        zaUpisivanje.setAutorKomentara(autor);
        zaUpisivanje.setObjava(objava);
        zaUpisivanje.setObrisan(false);
        zaUpisivanje.setTekstKomentara(komentarDTO.getTekstKomentara());
        zaUpisivanje.setDatumKreiranjaKomentara(LocalDate.now());

        komentariRepozitorijum.save(zaUpisivanje);

        return zaUpisivanje;
    }

    @Override
    public List<KomentarDTO> nadjiSveKomentareJedneObjave(int idObjave) {
        List<Komentar> nadjeni =  komentariRepozitorijum.nadjiSveKomentareJedneObjave(idObjave);
        List<KomentarDTO> trazeni = new ArrayList<>();
        for (Komentar k : nadjeni){
            KomentarDTO t = new KomentarDTO();
            t.setIdKomentara(k.getIdKomentara());
            t.setObjava(k.getObjava().getIdObjave());
            t.setAutorKomentara(k.getAutorKomentara().getKorisnickoIme());
            t.setTekstKomentara(k.getTekstKomentara());
            t.setObrisan(k.isObrisan());
            t.setDatumKreiranjaKomentara(k.getDatumKreiranjaKomentara().toString());

            trazeni.add(t);
        }
        return trazeni;
    }
}
