package case2.case2.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStreetDto {

    private Long id;

    private String name;

    private Long neighborhoodId;
}
