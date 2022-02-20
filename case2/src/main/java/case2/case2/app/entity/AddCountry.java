package case2.case2.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ADD_COUNTRY")
public class AddCountry {

    @Id
    @SequenceGenerator(name = "AddCountry" , sequenceName = "ADD_COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "AddCountry")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;
}
