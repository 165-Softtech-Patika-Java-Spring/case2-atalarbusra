package case2.case2.app.service;

import case2.case2.app.converter.AddAddressMapper;
import case2.case2.app.dto.AddCityDto;
import case2.case2.app.dto.AddCountryDto;
import case2.case2.app.dto.AddInsertCityDto;
import case2.case2.app.dto.AddInsertCountryDto;
import case2.case2.app.entity.AddCity;
import case2.case2.app.entity.AddCountry;
import case2.case2.app.service.entityService.AddCityEntityService;
import case2.case2.app.service.entityService.AddCountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddCityService {

    private final AddCityEntityService addCityEntityService;

    public AddCityDto save(AddInsertCityDto addInsertCityDto) {

        AddCity addCity = AddAddressMapper.INSTANCE.convertAddInsertCityDtoToAddInsertCity(addInsertCityDto);

        addCity = addCityEntityService.save(addCity);

        AddCityDto addCityDto = AddAddressMapper.INSTANCE.convertAddCityToAddCityDto(addCity);

        return addCityDto;
    }

    public AddCityDto findById(Long id) {

        AddCity addCity = addCityEntityService.getByIdWithControl(id);

        AddCityDto addCityDto = AddAddressMapper.INSTANCE.convertAddCityToAddCityDto(addCity);

        return addCityDto;
    }
}
