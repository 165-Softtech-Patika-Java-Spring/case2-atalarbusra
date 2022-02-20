package case2.case2.app.entity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ADD_ADDRESS")
public class AddAddress {

    @Id
    @SequenceGenerator(name = "AddAddress" , sequenceName = "ADD_ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "AddAddress")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "COUNTRY_ID", nullable = false)
    private Long countryId;

    @Column(name = "CITY_ID", nullable = false)
    private Long cityId;

    @Column(name = "DISTRICT_ID", nullable = false)
    private Long districtId;

    @Column(name = "NEIGHBORHOOD_ID", nullable = false)
    private Long neighborhoodId;

    @Column(name = "STREET_ID", nullable = false)
    private Long streetId;

    @Column(name = "DOOR_NO", nullable = false)
    private Long doorNo;

    @Column(name = "APARTMENT_NO", nullable = false)
    private Long apartmentNo;
}
