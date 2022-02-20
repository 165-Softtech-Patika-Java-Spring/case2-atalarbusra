package case2.case2.app.entity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ADD_DISTRICT")
public class AddDistrict {

    @Id
    @SequenceGenerator(name = "AddDistrict" , sequenceName = "ADD_DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "AddDistrict")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "CITY_ID", nullable = false)
    private Long cityId;
}
