package case2.case2.app.entity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ADD_CITY")
public class AddCity {

    @Id
    @SequenceGenerator(name = "AddCity" , sequenceName = "ADD_CITY_ID_SEQ")
    @GeneratedValue(generator = "AddCity")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "COUNTRY_ID", nullable = false)
    private Long countryId;
}
