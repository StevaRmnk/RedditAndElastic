package NoviStevinRedit.NoviStevinRedit.Servisi;

import NoviStevinRedit.NoviStevinRedit.DTO.CommunityDTO;
import NoviStevinRedit.NoviStevinRedit.DTO.CommunityGETDTO;
import NoviStevinRedit.NoviStevinRedit.Model.Zajednica;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommunityService {

    public List<Zajednica> nadjiSveZajednice();

    public List<CommunityGETDTO> nadjiZajednice();

    public Zajednica nadjiJednuZajednicu(int idZajednice);

    public void obrisiZajednicu(int idZajednice);

    public Zajednica sacuvajZajednicu(CommunityDTO communityDTO);

    public Zajednica azurirajZajednicu(CommunityDTO communityDTO, int idZajednice);

}
