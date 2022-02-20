package case2.case2.app.service.entityService;

import case2.case2.app.dao.AddStreetDao;
import case2.case2.app.entity.AddAddress;
import case2.case2.app.entity.AddDistrict;
import case2.case2.app.entity.AddStreet;
import case2.case2.app.enums.AddErrorMessage;
import case2.case2.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddStreetEntityService {

    private final AddStreetDao addStreetDao;

    public Optional<AddStreet> findById(Long id){
        return addStreetDao.findById(id);
    }

    public AddStreet save(AddStreet addStreet){
        return addStreetDao.save(addStreet);
    }


    public AddStreet getByIdWithControl(Long id) {

        Optional<AddStreet> customerOptional = findById(id);

        AddStreet addStreet;
        if (customerOptional.isPresent()){
            addStreet = customerOptional.get();
        } else {
            throw new ItemNotFoundException(AddErrorMessage.STREET_ERROR_MESSAGE);
        }

        return addStreet;
    }
    public List<AddStreet> findByNeighborhoodId(Long neighborhoodId) {

        List<AddStreet> addStreetList = addStreetDao.findAll();
        List<AddStreet> addStreets = new ArrayList<>();
        for(AddStreet addStreet : addStreetList){
            if(addStreet.getNeighborhoodId() == neighborhoodId){
                addStreets.add(addStreet);
            }
        }

        return addStreets;
    }

    public boolean existsById(Long id){
        return addStreetDao.existsById(id);
    }
}
