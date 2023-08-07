package NoviStevinRedit.NoviStevinRedit.DTOElastic;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjavaElDTO {

    private String naslovObjave;
    private String tekstObjave;
    private MultipartFile[] fajlovi;

}
