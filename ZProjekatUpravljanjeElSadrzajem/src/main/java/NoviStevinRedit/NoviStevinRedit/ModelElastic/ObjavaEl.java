package NoviStevinRedit.NoviStevinRedit.ModelElastic;

import NoviStevinRedit.NoviStevinRedit.Model.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "objave")
@Setting(settingPath = "/analyzers/serbianAnalyzer.json")
public class ObjavaEl {

    @Id
    private int idObjave;
    @Field(type = FieldType.Text)
    private String naslovObjave;

    @Field(type = FieldType.Text)
    private String tekstObjave;

    @Field(type = FieldType.Text)
   private String tekstPdf;

    private String filename;


}
