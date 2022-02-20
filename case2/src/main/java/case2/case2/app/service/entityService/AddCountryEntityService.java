package case2.case2.app.service.entityService;

import case2.case2.app.dao.AddCountryDao;
import case2.case2.app.entity.AddAddress;
import case2.case2.app.entity.AddCountry;
import case2.case2.app.enums.AddErrorMessage;
import case2.case2.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddCountryEntityService {
    private final AddCountryDao addCountryDao;

    public Optional<AddCountry> findById(Long id){
        return addCountryDao.findById(id);
    }

    public AddCountry save(AddCountry addCountry){
        return addCountryDao.save(addCountry);
    }

    public AddCountry getByIdWithControl(Long id) {

        Optional<AddCountry> countryOptional = findById(id);

        AddCountry addCountry;
        if (countryOptional.isPresent()){
            addCountry = countryOptional.get();
        } else {
            throw new ItemNotFoundException(AddErrorMessage.COUNTRY_ERROR_MESSAGE);
        }

        return addCountry;
    }
}
