package case2.case2.app.converter;

import case2.case2.app.dto.*;
import case2.case2.app.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddAddressMapper {

    AddAddressMapper INSTANCE = Mappers.getMapper(AddAddressMapper.class);

    AddAddressDto convertAddAddressToAddAddressDto (AddAddress addAddress);
    AddAddress convertAddInsertAddressDtoToAddInsertAddress(AddInsertAddressDto addInsertAddressDto);
    AddAddress convertAddAddressDtoToAddAddress (AddAddressDto addAddressDto);

    AddCity convertAddInsertCityDtoToAddInsertCity(AddInsertCityDto addInsertCityDto);
    AddCityDto convertAddCityToAddCityDto(AddCity addCity);

    AddCountry convertAddInsertCountryDtoToAddCountry(AddInsertCountryDto addInsertCountryDto);
    AddCountryDto convertAddCountryToAddCountryDto(AddCountry addCountry);

    AddDistrict convertAddInsertDistrictDtoToAddDistrict(AddInsertDistrictDto addInsertDistrictDto);
    AddDistrictDto convertAddDistrictToAddDistrictDto(AddDistrict addDistrict);
    List<AddDistrictDto> convertToAddDistrictDtoList(List<AddDistrict> cusCustomerList);


    AddNeighborhood convertAddInsertNeighborhoodDtoToAddNeighborhood(AddInsertNeighborhoodDto addInsertNeighborhoodDto);
    AddNeighborhoodDto convertAddNeighborhoodToAddNeighborhoodDto(AddNeighborhood addNeighborhood);
    AddNeighborhood convertAddNeighborhoodDtoToAddNeighborhood(AddNeighborhoodDto addNeighborhood);
    List<AddNeighborhoodDto> convertToAddNeighborhoodDtoList(List<AddNeighborhood> cusCustomerList);

    AddStreet convertAddInsertStreetDtoToAddStreet(AddInsertStreetDto addInsertStreetDto);
    AddStreetDto convertAddStreetToAddStreetDto(AddStreet addStreet);
    AddStreet convertAddStreetDtoToAddStreet(AddStreetDto addStreet);
    List<AddStreetDto> convertToAddStreetDtoList(List<AddStreet> cusCustomerList);

}
