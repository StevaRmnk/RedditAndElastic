package NoviStevinRedit.NoviStevinRedit.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostDTO {

    private String naslovObjave;


    private String tekstObjave;


    private String putanjaDoSlike;


    private String autorObjave;


    private int zajednica;

}
