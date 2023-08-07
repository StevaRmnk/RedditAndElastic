package NoviStevinRedit.NoviStevinRedit.Servisi;

import NoviStevinRedit.NoviStevinRedit.DTO.RuleDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Pravilo;

import java.util.List;

public interface PraviloServis {

    List<Pravilo> nadjiSvaPravila();

    List<Pravilo> nadjiSvaPravilaJedneZajednice(int idZajednice);

    Pravilo napraviPravilo(RuleDTO ruleDTO);
}
