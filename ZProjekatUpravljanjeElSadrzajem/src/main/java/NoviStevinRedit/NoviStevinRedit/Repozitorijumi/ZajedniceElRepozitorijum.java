package NoviStevinRedit.NoviStevinRedit.Repozitorijumi;

import NoviStevinRedit.NoviStevinRedit.ModelElastic.ZajednicaEl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZajedniceElRepozitorijum extends ElasticsearchRepository<ZajednicaEl,Integer> {
//
//    List<ZajednicaEl> findAllByImeZajednice(String naziv);
//    List<ZajednicaEl> findAllByOpisZajednice(String opis);
//    List<ZajednicaEl> findAllByPdfOpis(String tekstPDFa);
//    List<ZajednicaEl> findAll();
}
