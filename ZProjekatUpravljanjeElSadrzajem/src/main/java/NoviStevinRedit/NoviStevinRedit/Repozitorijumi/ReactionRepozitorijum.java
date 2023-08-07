package NoviStevinRedit.NoviStevinRedit.Repozitorijumi;

import NoviStevinRedit.NoviStevinRedit.Model.Reaction;
import NoviStevinRedit.NoviStevinRedit.Model.ReactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ReactionRepozitorijum extends JpaRepository<Reaction,Integer> {

    @Query(value = "select * from reakcije r  where r.id_objave = ?1",
            nativeQuery = true)
    List<Reaction> nadjiSveReakcijeZaJednuObjavu(int idObjave);

    @Modifying
    @Transactional
    @Query(value = "update reakcije r set r.tip_reakcije = ?1 where r.id_reakcije = ?2 ",
    nativeQuery = true)
    void izmeniTipReakcije( String stri,int idrReakcije);

    @Modifying
    @Transactional
    @Query(value = "delete from reakcije where id_objave = ?1",nativeQuery = true
    )
    void ObrisiSveReakcijeZaJednuObjavu(int idObjave);

}
