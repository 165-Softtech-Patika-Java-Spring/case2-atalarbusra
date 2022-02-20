package case2.case2.app.dao;

import case2.case2.app.entity.AddCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddCountryDao  extends JpaRepository<AddCountry, Long> {
}
