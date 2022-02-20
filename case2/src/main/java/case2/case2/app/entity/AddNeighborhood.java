package case2.case2.app.entity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ADD_NEIGHBORHOOD")
public class AddNeighborhood {

    @Id
    @SequenceGenerator(name = "AddNeighborhood" , sequenceName = "ADD_NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "AddNeighborhood")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "DISTRICT_ID", nullable = false)
    private Long districtId;
}
