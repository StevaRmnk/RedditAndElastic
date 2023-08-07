package NoviStevinRedit.NoviStevinRedit.Repozitorijumi;

import NoviStevinRedit.NoviStevinRedit.Model.Objava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface PostsRepozitorijum extends JpaRepository<Objava,Integer> {

    @Transactional
    @Query(value = "select * from objave o  where o.id_zajednice = ?1",
    nativeQuery = true)
    List<Objava>nadjiSveObjaveJedneZajednice(int idZajednice);

    //@Query (value = "select * from posts p where p.community_id = ?1", nativeQuery = true)

    @Transactional
    @Query(value = "select * from objave where autor = ?1", nativeQuery = true)
    List<Objava> nadjiSveObjaveJednogKorisnika(String korisnickoIme);

}
