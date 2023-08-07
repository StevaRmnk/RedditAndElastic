package NoviStevinRedit.NoviStevinRedit.ServisiImplement;

import NoviStevinRedit.NoviStevinRedit.DTO.RuleDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Pravilo;
import NoviStevinRedit.NoviStevinRedit.Model.Zajednica;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.CommunitiesRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.PravilaRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.Servisi.PraviloServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PraviloServisImpl implements PraviloServis {

    @Autowired
    PravilaRepozitorijum pravilaRepozitorijum;

    @Autowired
    CommunitiesRepozitorijum communitiesRepozitorijum;

    @Override
    public List<Pravilo> nadjiSvaPravila() {
        return pravilaRepozitorijum.findAll();
    }

    @Override
    public List<Pravilo> nadjiSvaPravilaJedneZajednice(int idZajednice) {
        return pravilaRepozitorijum.nadjiSvaPravilaJedneZajednice(idZajednice);
    }

    @Override
    public Pravilo napraviPravilo(RuleDTO ruleDTO) {

        Zajednica zaj = communitiesRepozitorijum.findById(ruleDTO.getZajednica()).orElseGet(null);

        Pravilo novo = new Pravilo();
        novo.setOpisPravila(ruleDTO.getOpisPravila());
        novo.setZajednica(zaj);

        pravilaRepozitorijum.save(novo);

        return novo;
    }
}
