package NoviStevinRedit.NoviStevinRedit.ModelElastic;


import NoviStevinRedit.NoviStevinRedit.Model.RazlogPrijave;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "zajednice")
@Setting(settingPath = "/analyzers/serbianAnalyzer.json")
public class ZajednicaEl {
    @Id
    private int idZajednice;
    @Field(type = FieldType.Text)
    private String imeZajednice;
    @Field(type = FieldType.Text)
    private String opisZajednice;
    @Field(type = FieldType.Text)
    private String pdfOpis;

    private String filename;

}
