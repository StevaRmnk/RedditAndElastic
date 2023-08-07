package NoviStevinRedit.NoviStevinRedit.Repozitorijumi;

import NoviStevinRedit.NoviStevinRedit.Model.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KomentariRepozitorijum extends JpaRepository<Komentar,Integer> {

    @Query(value = "select * from komentari k where k.id_objave = ?1",nativeQuery = true)
    List<Komentar> nadjiSveKomentareJedneObjave(int idObjave);
}
