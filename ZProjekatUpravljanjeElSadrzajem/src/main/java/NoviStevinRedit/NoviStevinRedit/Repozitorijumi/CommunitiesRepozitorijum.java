package NoviStevinRedit.NoviStevinRedit.Repozitorijumi;

import NoviStevinRedit.NoviStevinRedit.Model.Zajednica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommunitiesRepozitorijum extends JpaRepository<Zajednica,Integer> {


    @Query(value = "delete from zajednice where id_zajednice = idZajednice",
            nativeQuery = true)
    void obrisiObjavu(int idZajednice);
}
