package NoviStevinRedit.NoviStevinRedit.Repozitorijumi;

import NoviStevinRedit.NoviStevinRedit.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UsersRepozitorijum extends JpaRepository<Korisnik,String> {
    @Transactional
    @Modifying
    @Query(value = "update korisnici set lozinka = ?1 where korisnicko_ime = ?2",nativeQuery = true)
    public void IzmeniLozinkuKorisnika(String novaLozinka, String korisnickoIme);

}
