package NoviStevinRedit.NoviStevinRedit.DTOElastic;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ZajednicaElDTO {
    private String imeZajednice;
    private String opisZajednice;
    private MultipartFile[] fajlovi;
}
