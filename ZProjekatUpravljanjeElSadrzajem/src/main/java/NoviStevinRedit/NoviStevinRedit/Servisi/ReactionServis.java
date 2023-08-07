package NoviStevinRedit.NoviStevinRedit.Servisi;

import NoviStevinRedit.NoviStevinRedit.DTO.ReactionDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Reaction;

import java.util.List;

public interface ReactionServis {

    public List<Reaction> nadjiSveReakcijeZaJednuObjavu(int idObjave);

    public List<Reaction> nadjiSveReakcije();

    public Reaction sacuvajReakciju(ReactionDTO reakcija);

    public void obrisisveReakcijezaJednuObjavu(int idObjave);

    public int nadjiKarmuObjave(int idObjave);
}
