package NoviStevinRedit.NoviStevinRedit.lucene.indexing.handlers;

import NoviStevinRedit.NoviStevinRedit.ModelElastic.ObjavaEl;
import NoviStevinRedit.NoviStevinRedit.ModelElastic.ZajednicaEl;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFHandler extends DocumentHandler{
    @Override
    public ZajednicaEl getIndexUnitCommunity(File file) {
        ZajednicaEl povratnaVrednost = new ZajednicaEl();
        try {
            PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
            parser.parse();
            String text = getText(parser);
            povratnaVrednost.setPdfOpis(text);

            PDDocument pdf = parser.getPDDocument();
            povratnaVrednost.setFilename(
                    file.getCanonicalPath());

            pdf.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom konvertovanja iz dokumenta u PDF");
        }

        return povratnaVrednost;
    }

    @Override
    public ObjavaEl getIndexUnitPost(File file) {
        ObjavaEl povratnaVrednost = new ObjavaEl();
        try {
            PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
            parser.parse();
            String text = getText(parser);
            povratnaVrednost.setTekstPdf(text);

            PDDocument pdf = parser.getPDDocument();

            povratnaVrednost.setFilename(file.getCanonicalPath());

            pdf.close();
        } catch (IOException e) {
            System.out.println("Greska prilikom konvertovanja iz dokumenta u PDF");
        }

        return povratnaVrednost;
    }


    @Override
    public String getText(File file) {
        try {
            PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
            parser.parse();
            PDFTextStripper textStripper = new PDFTextStripper();
            return textStripper.getText(parser.getPDDocument());
        } catch (IOException e) {
            System.out.println("Greska prilikom konvertovanja iz dokumenta u PDF");
        }
        return null;
    }


    public String getText(PDFParser parser) {
        try {
            PDFTextStripper textStripper = new PDFTextStripper();
            return textStripper.getText(parser.getPDDocument());
        } catch (IOException e) {
            System.out.println("Greska prilikom konvertovanja iz dokumenta u PDF");
        }
        return null;
    }
}
