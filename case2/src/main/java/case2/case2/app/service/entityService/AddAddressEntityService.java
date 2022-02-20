package case2.case2.app.service.entityService;

import case2.case2.app.dao.AddAddressDao;
import case2.case2.app.dto.AddAddressDto;
import case2.case2.app.entity.AddAddress;
import case2.case2.app.enums.AddErrorMessage;
import case2.case2.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddAddressEntityService {

    private final AddAddressDao addAddressDao;

    public Optional<AddAddress> findById(Long id){
        return addAddressDao.findById(id);
    }

    public AddAddress save(AddAddress addAddress){
        return addAddressDao.save(addAddress);
    }

    public AddAddress getByIdWithControl(Long id) {

        Optional<AddAddress> customerOptional = findById(id);

        AddAddress cusCustomer;
        if (customerOptional.isPresent()){
            cusCustomer = customerOptional.get();
        } else {
            throw new ItemNotFoundException(AddErrorMessage.ADDRESS_ERROR_MESSAGE);
        }

        return cusCustomer;
    }

    public void delete(AddAddress addAddress){
        addAddressDao.delete(addAddress);
    }

}
