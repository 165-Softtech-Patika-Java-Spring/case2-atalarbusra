package case2.case2.app.service.entityService;

import case2.case2.app.dao.AddDistrictDao;
import case2.case2.app.entity.AddAddress;
import case2.case2.app.entity.AddCountry;
import case2.case2.app.entity.AddDistrict;
import case2.case2.app.enums.AddErrorMessage;
import case2.case2.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddDistrictEntityService {

    private final AddDistrictDao addDistrictDao;

    public Optional<AddDistrict> findById(Long id){
        return addDistrictDao.findById(id);
    }

    public AddDistrict save(AddDistrict addDistrict){
        return addDistrictDao.save(addDistrict);
    }

    public AddDistrict getByIdWithControl(Long id) {

        Optional<AddDistrict> customerOptional = findById(id);

        AddDistrict addDistrict;
        if (customerOptional.isPresent()){
            addDistrict = customerOptional.get();
        } else {
            throw new ItemNotFoundException(AddErrorMessage.DISTRICT_ERROR_MESSAGE);
        }

        return addDistrict;
    }

    public List<AddDistrict> findByCityId(Long cityId) {

        List<AddDistrict> districtList = addDistrictDao.findAll();
        List<AddDistrict> addDistricts = new ArrayList<>();
        for(AddDistrict addDistrict : districtList){
            if(addDistrict.getCityId() == cityId){
                addDistricts.add(addDistrict);
            }
        }

        return addDistricts;
    }

}
