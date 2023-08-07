package NoviStevinRedit.NoviStevinRedit.Repozitorijumi;

import NoviStevinRedit.NoviStevinRedit.Model.Pravilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PravilaRepozitorijum extends JpaRepository<Pravilo,Integer> {

    @Query(value = "select * from pravila p where p.id_zajednice = ?1",nativeQuery = true)
    List<Pravilo> nadjiSvaPravilaJedneZajednice(int idZajednice);

}
