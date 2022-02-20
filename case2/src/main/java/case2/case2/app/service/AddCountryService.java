package case2.case2.app.service;

import case2.case2.app.converter.AddAddressMapper;
import case2.case2.app.dto.AddCountryDto;
import case2.case2.app.dto.AddInsertCountryDto;
import case2.case2.app.entity.AddCountry;
import case2.case2.app.service.entityService.AddCountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddCountryService {

    private final AddCountryEntityService addCountryEntityService;


    public AddCountryDto save(AddInsertCountryDto addInsertCountryDto) {

        AddCountry addCountry = AddAddressMapper.INSTANCE.convertAddInsertCountryDtoToAddCountry(addInsertCountryDto);

        addCountry = addCountryEntityService.save(addCountry);

        AddCountryDto addCountryDto = AddAddressMapper.INSTANCE.convertAddCountryToAddCountryDto(addCountry);

        return addCountryDto;
    }

    public AddCountryDto findById(Long id) {

        AddCountry addCountry = addCountryEntityService.getByIdWithControl(id);

        AddCountryDto addCountryDto = AddAddressMapper.INSTANCE.convertAddCountryToAddCountryDto(addCountry);

        return addCountryDto;
    }
}
