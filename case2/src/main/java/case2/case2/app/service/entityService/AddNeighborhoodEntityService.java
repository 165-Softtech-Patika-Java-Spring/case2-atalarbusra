package case2.case2.app.service.entityService;

import case2.case2.app.converter.AddAddressMapper;
import case2.case2.app.dao.AddNeighborhoodDao;
import case2.case2.app.dao.AddStreetDao;
import case2.case2.app.dto.AddDistrictDto;
import case2.case2.app.entity.AddAddress;
import case2.case2.app.entity.AddDistrict;
import case2.case2.app.entity.AddNeighborhood;
import case2.case2.app.enums.AddErrorMessage;
import case2.case2.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddNeighborhoodEntityService {

    private final AddNeighborhoodDao addNeighborhoodDao;

    public Optional<AddNeighborhood> findById(Long id){
        return addNeighborhoodDao.findById(id);
    }
    public AddNeighborhood save(AddNeighborhood addNeighborhood){
        return addNeighborhoodDao.save(addNeighborhood);
    }

    public AddNeighborhood getByIdWithControl(Long id) {

        Optional<AddNeighborhood> customerOptional = findById(id);

        AddNeighborhood addNeighborhood;
        if (customerOptional.isPresent()){
            addNeighborhood = customerOptional.get();
        } else {
            throw new ItemNotFoundException(AddErrorMessage.NEIGHBORHOOD_ERROR_MESSAGE);
        }

        return addNeighborhood;
    }

    public List<AddNeighborhood> findByDistrictId(Long districtId) {

        List<AddNeighborhood> neighborhoodList = addNeighborhoodDao.findAll();

        List<AddNeighborhood> addNeighborhoodList = new ArrayList<>();
        for(AddNeighborhood addNeighborhood : neighborhoodList){
            if(addNeighborhood.getDistrictId() == districtId){
                addNeighborhoodList.add(addNeighborhood);
            }
        }

        return addNeighborhoodList;
    }

    public boolean existsById(Long id){
        return addNeighborhoodDao.existsById(id);
    }
}
