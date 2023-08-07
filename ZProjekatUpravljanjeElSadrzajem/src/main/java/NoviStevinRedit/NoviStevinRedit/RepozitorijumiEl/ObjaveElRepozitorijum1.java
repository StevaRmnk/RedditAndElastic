package NoviStevinRedit.NoviStevinRedit.RepozitorijumiEl;

import NoviStevinRedit.NoviStevinRedit.ModelElastic.ObjavaEl;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjaveElRepozitorijum1 extends ElasticsearchRepository<ObjavaEl,Integer> {
    List<ObjavaEl> findAllByNaslovObjave(String naslovObjave);
    List<ObjavaEl> findAllByTekstObjave(String tekstObjave);
    List<ObjavaEl> findAllByTekstPdf(String tekstPDFa);
    List<ObjavaEl> findAll();
}
