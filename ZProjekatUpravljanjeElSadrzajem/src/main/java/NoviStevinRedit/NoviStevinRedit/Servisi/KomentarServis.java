package NoviStevinRedit.NoviStevinRedit.Servisi;


import NoviStevinRedit.NoviStevinRedit.DTO.KomentarDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Komentar;

import java.util.List;

public interface KomentarServis {

    List<Komentar> nadjiSveKomentare();

    List<KomentarDTO> nadjiSveKomentareDTO();

    Komentar nadjiJedanKomentar(int idKomentara);

    KomentarDTO nadjiJedanKomentarDTO(int idKomentara);

    Komentar sacuvajKomentar(KomentarDTO komentarDTO);

    List<KomentarDTO> nadjiSveKomentareJedneObjave(int idObjave);


}
