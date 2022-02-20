package case2.case2.app.service;

import case2.case2.app.converter.AddAddressMapper;
import case2.case2.app.dto.*;
import case2.case2.app.entity.AddAddress;
import case2.case2.app.entity.AddCity;
import case2.case2.app.entity.AddStreet;
import case2.case2.app.service.entityService.AddAddressEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddAddressService {

    private final AddAddressEntityService addAddressEntityService;

    public AddAddressDto save(AddInsertAddressDto addInsertAddressDto) {

        AddAddress addAddress = AddAddressMapper.INSTANCE.convertAddInsertAddressDtoToAddInsertAddress(addInsertAddressDto);

        addAddress = addAddressEntityService.save(addAddress);

        AddAddressDto addAddressDto = AddAddressMapper.INSTANCE.convertAddAddressToAddAddressDto(addAddress);

        return addAddressDto;
    }

    public AddAddressDto findById(Long id) {

        AddAddress addAddress = addAddressEntityService.getByIdWithControl(id);

        AddAddressDto addAddressDto = AddAddressMapper.INSTANCE.convertAddAddressToAddAddressDto(addAddress);

        return addAddressDto;
    }

    public void delete(Long id) {

        AddAddress cusCustomer = addAddressEntityService.getByIdWithControl(id);

        addAddressEntityService.delete(cusCustomer);
    }

}
