package case2.case2.app.service;

import case2.case2.app.converter.AddAddressMapper;
import case2.case2.app.dto.AddCityDto;
import case2.case2.app.dto.AddDistrictDto;
import case2.case2.app.dto.AddInsertCityDto;
import case2.case2.app.dto.AddInsertDistrictDto;
import case2.case2.app.entity.AddCity;
import case2.case2.app.entity.AddDistrict;
import case2.case2.app.service.entityService.AddDistrictEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddDistrictService {

    private final AddDistrictEntityService addDistrictEntityService;

    public AddDistrictDto save(AddInsertDistrictDto addInsertDistrictDto) {

        AddDistrict addDistrict = AddAddressMapper.INSTANCE.convertAddInsertDistrictDtoToAddDistrict(addInsertDistrictDto);

        addDistrict = addDistrictEntityService.save(addDistrict);

        AddDistrictDto addDistrictDto = AddAddressMapper.INSTANCE.convertAddDistrictToAddDistrictDto(addDistrict);

        return addDistrictDto;
    }
    public AddDistrictDto findById(Long id) {

        AddDistrict addDistrict = addDistrictEntityService.getByIdWithControl(id);

        AddDistrictDto addDistrictDto = AddAddressMapper.INSTANCE.convertAddDistrictToAddDistrictDto(addDistrict);

        return addDistrictDto;
    }

    public List<AddDistrictDto> findByCityId(Long cityId) {

         List<AddDistrict> addDistrictList = addDistrictEntityService.findByCityId(cityId);

        List<AddDistrictDto> addDistrictDtoList = AddAddressMapper.INSTANCE.convertToAddDistrictDtoList(addDistrictList);

        return addDistrictDtoList;
    }

}
