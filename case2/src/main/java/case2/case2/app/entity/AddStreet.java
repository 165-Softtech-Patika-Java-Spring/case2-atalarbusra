package case2.case2.app.entity;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ADD_STREET")
public class AddStreet {

    @Id
    @SequenceGenerator(name = "AddStreet" , sequenceName = "ADD_STREET_ID_SEQ")
    @GeneratedValue(generator = "AddStreet")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "NEIGHBORHOOD_ID", nullable = false)
    private Long neighborhoodId;
}
