package NoviStevinRedit.NoviStevinRedit.ServisiImplement;

import NoviStevinRedit.NoviStevinRedit.DTOElastic.ObjavaElDTO;
import NoviStevinRedit.NoviStevinRedit.ModelElastic.ObjavaEl;
import NoviStevinRedit.NoviStevinRedit.RepozitorijumiEl.ObjaveElRepozitorijum1;
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

@Service
public class ObjaveServisElImpl {

    @Value("${files.path}")
    private String filesPath;
    @Autowired
    private ObjaveElRepozitorijum1 objaveElRepo;

    public List<ObjavaEl> nadjiObjavePoNaslovu(String naslovObjave) {
        return objaveElRepo.findAllByNaslovObjave(naslovObjave);
    }


    public List<ObjavaEl> nadjiObjavePoTekstuPDFa(String pdfText) {
        return objaveElRepo.findAllByTekstPdf(pdfText);
    }

    public List<ObjavaEl> nadjiObjavePoTekstu(String text) {
        return objaveElRepo.findAllByTekstObjave(text);
    }

    public List<ObjavaEl> nadjiObjave() {
        return objaveElRepo.findAll();
    }

    public void sacuvajObjavu(ObjavaEl objavaEl) {
        objaveElRepo.save(objavaEl);
    }

    public void sacuvajUploadovaniFajl(ObjavaElDTO objavaElDTO) throws IOException {
        if (objavaElDTO.getFajlovi() != null) {
            for (MultipartFile file : objavaElDTO.getFajlovi()) {
                if (file.isEmpty()) {
                    continue;
                }

                String fileName = sacuvajUploadovanFajlNaSistemu(file);
                if (fileName != null) {
                    ObjavaEl postIndexUnit = nadjiFajl(fileName).getIndexUnitPost(new File(fileName));
                    postIndexUnit.setNaslovObjave(objavaElDTO.getNaslovObjave());
                    postIndexUnit.setTekstObjave(objavaElDTO.getTekstObjave());
                    sacuvajObjavu(postIndexUnit);
                }
            }
        } else {
            ObjavaEl postIndexUnit = new ObjavaEl();
            postIndexUnit.setNaslovObjave(objavaElDTO.getNaslovObjave());
            postIndexUnit.setTekstObjave(objavaElDTO.getTekstObjave());
            postIndexUnit.setTekstPdf(null);
            postIndexUnit.setFilename(null);

            sacuvajObjavu(postIndexUnit);
        }
    }

    public DocumentHandler nadjiFajl(String imeFajla) {
        return getDocumentHandler(imeFajla);
    }

    public static DocumentHandler getDocumentHandler(String fileName) {
        if (fileName.endsWith(".pdf")) {
            return new PDFHandler();
        } else {
            return null;
        }
    }


    public String sacuvajUploadovanFajlNaSistemu(MultipartFile file) throws IOException {
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
