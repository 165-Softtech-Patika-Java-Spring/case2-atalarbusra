package case2.case2.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAddressDto {

    private Long id;

    private String name;

    private Long cityId;

    private Long streetId;

    private Long countryId;

    private Long districtId;

    private Long doorNo;

    private Long apartmentNo;
}
