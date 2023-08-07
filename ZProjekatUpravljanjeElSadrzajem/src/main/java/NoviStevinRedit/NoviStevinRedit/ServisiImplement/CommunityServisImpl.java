package NoviStevinRedit.NoviStevinRedit.ServisiImplement;

import NoviStevinRedit.NoviStevinRedit.DTO.CommunityDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.CommunityGETDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Objava;
import NoviStevinRedit.NoviStevinRedit.Model.Zajednica;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.CommunitiesRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.UsersRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Servisi.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CommunityServisImpl  implements CommunityService {

    @Autowired
    CommunitiesRepozitorijum communitiesRepozitorijum;

    @Autowired
    UsersRepozitorijum usersRepozitorijum;

    @Override
    public List<Zajednica> nadjiSveZajednice() {
        return communitiesRepozitorijum.findAll();
    }

    @Override
    public List<CommunityGETDTO> nadjiZajednice() {

        List<Zajednica> zajednice = nadjiSveZajednice();
        List<CommunityGETDTO> sveZajednice = new ArrayList<>();

        for(Zajednica zaj : zajednice){
            CommunityGETDTO jednaZaj = new CommunityGETDTO();
            jednaZaj.setIdZajednice(zaj.getIdZajednice());
            jednaZaj.setImeZajednice(zaj.getImeZajednice());
            jednaZaj.setOpisZajednice(zaj.getOpisZajednice());

            sveZajednice.add(jednaZaj);
        }

        return sveZajednice;
    }


    @Override
    public Zajednica nadjiJednuZajednicu(int idZajednice) {
        return communitiesRepozitorijum.findById(idZajednice).orElseGet(null);
    }

    @Override
    public void obrisiZajednicu(int idZajednice) {
    communitiesRepozitorijum.obrisiObjavu(idZajednice);
    }

    @Override
    public Zajednica sacuvajZajednicu(CommunityDTO zajednica) {


        Set<Objava> listaObjava = new HashSet<>();

        Zajednica novaZajednica = new Zajednica();
        novaZajednica.setImeZajednice(zajednica.getImeZajednice());
        novaZajednica.setOpisZajednice(zajednica.getOpisZajednice());
        novaZajednica.setDatumKreiranja(LocalDate.now());
        novaZajednica.setSuspendovana(false);
        novaZajednica.setRazlogPrijave(null);
        novaZajednica.setListaObjavi(listaObjava);

        communitiesRepozitorijum.save(novaZajednica);
        return novaZajednica;
    }

    @Override
    public Zajednica azurirajZajednicu(CommunityDTO communityDTO, int idZajednice) {
        Zajednica zajednica = nadjiJednuZajednicu(idZajednice);
        if(communityDTO.getImeZajednice() != null){
            zajednica.setImeZajednice(communityDTO.getImeZajednice());
        }
        if(communityDTO.getOpisZajednice() != null){
            zajednica.setOpisZajednice(communityDTO.getOpisZajednice());
        }
        communitiesRepozitorijum.save(zajednica);
        return zajednica;

    }


}
