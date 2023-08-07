package NoviStevinRedit.NoviStevinRedit.ServisiImplement;

import NoviStevinRedit.NoviStevinRedit.DTOElastic.ZajednicaElDTO;
import NoviStevinRedit.NoviStevinRedit.ModelElastic.ZajednicaEl;
import NoviStevinRedit.NoviStevinRedit.Repozitorijumi.ZajedniceElRepozitorijum;
import NoviStevinRedit.NoviStevinRedit.RepozitorijumiEl.ZajedniceElRepozitorijum1;
import NoviStevinRedit.NoviStevinRedit.lucene.indexing.handlers.DocumentHandler;
import NoviStevinRedit.NoviStevinRedit.lucene.indexing.handlers.PDFHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Service
public class ZajedniceServisElImpl {

    @Value("${files.path}")
    private String filesPath;

    @Autowired
    private ZajedniceElRepozitorijum1 zajedniceElRepo;

//    private final ZajedniceElRepozitorijum1 zajedniceElRepo;
//    @Autowired
//    public ZajedniceServisElImpl(ZajedniceElRepozitorijum zajedniceElRepo){
//        this.zajedniceElRepo = zajedniceElRepo;
//    }
//

    public List<ZajednicaEl> nadjiZajednicePoNazivu(String nazivZajednice) {
        return zajedniceElRepo.findAllByImeZajednice(nazivZajednice);
    }


    public List<ZajednicaEl> nadjiZajednicePoOpisu(String opisZajednice) {
        return zajedniceElRepo.findAllByOpisZajednice(opisZajednice);
    }


    public List<ZajednicaEl> nadjiZajednicePoOpisuPDF(String opisPDF) {
        return zajedniceElRepo.findAllByPdfOpis(opisPDF);
    }


    public List<ZajednicaEl> nadjiSveZajednice() {
        return zajedniceElRepo.findAll();
    }


    public void sacuvajZajednicuElastik(ZajednicaEl zajednicaEl) {
        zajedniceElRepo.save(zajednicaEl);
    }


    public void sacuvajUploadovanFajl(ZajednicaElDTO zajednicaElDTO) throws IOException {
        if (zajednicaElDTO.getFajlovi() != null) {
            for (MultipartFile file : zajednicaElDTO.getFajlovi()) {
                if (file.isEmpty()) {
                    continue;
                }

                String fileName = sacuvajUploadovanFajlUSistemu(file);
                if (fileName != null) {
                    ZajednicaEl communityIndexUnit = nadjiFajl(fileName).getIndexUnitCommunity(new File(fileName));
                    communityIndexUnit.setImeZajednice(zajednicaElDTO.getImeZajednice());
                    communityIndexUnit.setOpisZajednice(zajednicaElDTO.getOpisZajednice());

                    sacuvajZajednicuElastik(communityIndexUnit);
                }
            }
        } else {
            ZajednicaEl communityIndexUnit = new ZajednicaEl();
            communityIndexUnit.setImeZajednice(zajednicaElDTO.getImeZajednice());
            communityIndexUnit.setOpisZajednice(zajednicaElDTO.getOpisZajednice());
            communityIndexUnit.setPdfOpis(null);
            communityIndexUnit.setFilename(null);

            Random r = new Random();
            double randomValue = 9.0 * r.nextDouble();

            sacuvajZajednicuElastik(communityIndexUnit);
        }
    }


    public DocumentHandler nadjiFajl(String imeFajla) {
        return getDocumentHandler(imeFajla);
    }

    public static DocumentHandler getDocumentHandler(String imefajla) {
        if (imefajla.endsWith(".pdf")) {
            return new PDFHandler();
        } else {
            return null;
        }
    }


    public String sacuvajUploadovanFajlUSistemu(MultipartFile file) throws IOException {
        String retVal = null;
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(new File(filesPath).getAbsolutePath() + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);
            retVal = path.toString();
        }
        return retVal;
    }
}
