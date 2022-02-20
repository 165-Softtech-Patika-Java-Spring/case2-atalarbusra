package case2.case2.app.service;

import case2.case2.app.converter.AddAddressMapper;
import case2.case2.app.dto.*;
import case2.case2.app.entity.AddAddress;
import case2.case2.app.entity.AddDistrict;
import case2.case2.app.entity.AddNeighborhood;
import case2.case2.app.entity.AddStreet;
import case2.case2.app.enums.AddErrorMessage;
import case2.case2.app.service.entityService.AddStreetEntityService;
import case2.case2.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddStreetService {
    private final AddStreetEntityService addStreetEntityService;

    public AddStreetDto save(AddInsertStreetDto addInsertStreetDto) {

        AddStreet addStreet = AddAddressMapper.INSTANCE.convertAddInsertStreetDtoToAddStreet(addInsertStreetDto);

        addStreet = addStreetEntityService.save(addStreet);

        AddStreetDto addStreetDto = AddAddressMapper.INSTANCE.convertAddStreetToAddStreetDto(addStreet);

        return addStreetDto;
    }

    public List<AddStreetDto> findByNeighborhoodId(Long neighborhoodId) {

        List<AddStreet> addStreetList = addStreetEntityService.findByNeighborhoodId(neighborhoodId);

        List<AddStreetDto> addStreetDtoList = AddAddressMapper.INSTANCE.convertToAddStreetDtoList(addStreetList);

        return addStreetDtoList;
    }

    public AddStreetDto update(AddStreetDto addStreetDto) {

        if (!addStreetEntityService.existsById(addStreetDto.getId())) {
            throw new ItemNotFoundException(AddErrorMessage.STREET_ERROR_MESSAGE);
        }

        AddStreet addStreet = AddAddressMapper.INSTANCE.convertAddStreetDtoToAddStreet(addStreetDto);
        addStreetEntityService.save(addStreet);

        addStreetDto = AddAddressMapper.INSTANCE.convertAddStreetToAddStreetDto(addStreet);

        return addStreetDto;
    }

}
