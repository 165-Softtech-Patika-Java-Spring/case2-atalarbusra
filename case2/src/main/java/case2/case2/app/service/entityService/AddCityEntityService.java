package case2.case2.app.service.entityService;

import case2.case2.app.dao.AddCityDao;
import case2.case2.app.entity.AddAddress;
import case2.case2.app.entity.AddCity;
import case2.case2.app.enums.AddErrorMessage;
import case2.case2.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddCityEntityService {

    private final AddCityDao addCityDao;

    public Optional<AddCity> findById(Long id){
        return addCityDao.findById(id);
    }
    public AddCity save(AddCity addCity){
        return addCityDao.save(addCity);
    }


    public AddCity getByIdWithControl(Long id) {

        Optional<AddCity> customerOptional = findById(id);

        AddCity addCity;
        if (customerOptional.isPresent()){
            addCity = customerOptional.get();
        } else {
            throw new ItemNotFoundException(AddErrorMessage.CITY_ERROR_MESSAGE);
        }

        return addCity;
    }
}
