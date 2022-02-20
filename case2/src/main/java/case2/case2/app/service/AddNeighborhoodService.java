package case2.case2.app.service;

import case2.case2.app.converter.AddAddressMapper;
import case2.case2.app.dto.AddDistrictDto;
import case2.case2.app.dto.AddInsertNeighborhoodDto;
import case2.case2.app.dto.AddNeighborhoodDto;
import case2.case2.app.dto.AddStreetDto;
import case2.case2.app.entity.AddDistrict;
import case2.case2.app.entity.AddNeighborhood;
import case2.case2.app.entity.AddStreet;
import case2.case2.app.enums.AddErrorMessage;
import case2.case2.app.service.entityService.AddNeighborhoodEntityService;
import case2.case2.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddNeighborhoodService {

    private final AddNeighborhoodEntityService addNeighborhoodEntityService;

    public AddNeighborhoodDto save(AddInsertNeighborhoodDto addInsertNeighborhoodDto) {

        AddNeighborhood addNeighborhood = AddAddressMapper.INSTANCE.convertAddInsertNeighborhoodDtoToAddNeighborhood(addInsertNeighborhoodDto);

        addNeighborhood = addNeighborhoodEntityService.save(addNeighborhood);

        AddNeighborhoodDto addCityDto = AddAddressMapper.INSTANCE.convertAddNeighborhoodToAddNeighborhoodDto(addNeighborhood);

        return addCityDto;
    }

    public List<AddNeighborhoodDto> findByDistrictId(Long districtId) {

        List<AddNeighborhood> addNeighborhoodList = addNeighborhoodEntityService.findByDistrictId(districtId);

        List<AddNeighborhoodDto> addNeighborhoodDtoList = AddAddressMapper.INSTANCE.convertToAddNeighborhoodDtoList(addNeighborhoodList);

        return addNeighborhoodDtoList;
    }

    public AddNeighborhoodDto update(AddNeighborhoodDto addNeighborhoodDto) {
        if (!addNeighborhoodEntityService.existsById(addNeighborhoodDto.getId())) {
            throw new ItemNotFoundException(AddErrorMessage.STREET_ERROR_MESSAGE);
        }
        AddNeighborhood addNeighborhood = AddAddressMapper.INSTANCE.convertAddNeighborhoodDtoToAddNeighborhood(addNeighborhoodDto);
        addNeighborhoodEntityService.save(addNeighborhood);

        addNeighborhoodDto = AddAddressMapper.INSTANCE.convertAddNeighborhoodToAddNeighborhoodDto(addNeighborhood);

        return addNeighborhoodDto;

    }
}
