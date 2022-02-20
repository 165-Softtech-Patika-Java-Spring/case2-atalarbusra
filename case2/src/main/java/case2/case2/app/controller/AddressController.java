package case2.case2.app.controller;


import case2.case2.app.dto.*;
import case2.case2.app.entity.AddAddress;
import case2.case2.app.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addressService")
@RequiredArgsConstructor
public class AddressController {

    private final AddAddressService addAddressService;

    private final AddCityService addCityService;

    private final AddCountryService addCountryService;

    private final AddDistrictService addDistrictService;

    private final AddNeighborhoodService addNeighborhoodService;

    private final AddStreetService addStreetService;

    @RequestMapping(method = RequestMethod.GET, value = "/country")
    public ResponseEntity findById(Long id) {

        AddCountryDto addCountryDto = addCountryService.findById(id);

        return ResponseEntity.ok(addCountryDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/country/save")
    public ResponseEntity save(@RequestBody AddInsertCountryDto addInsertCountryDto) {

        AddCountryDto addCountryDto = addCountryService.save(addInsertCountryDto);

        return ResponseEntity.ok(addCountryDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/city")
    public ResponseEntity AddCityfindById(Long id) {

        AddCityDto addCityDto = addCityService.findById(id);

        return ResponseEntity.ok(addCityDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/city/save")
    public ResponseEntity save(@RequestBody AddInsertCityDto addInsertCityDto) {

        AddCityDto addCityDto = addCityService.save(addInsertCityDto);

        return ResponseEntity.ok(addCityDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/district")
    public ResponseEntity AddDistrictfindByCityId(Long cityId) {

        List<AddDistrictDto> addDistrictDtoList = addDistrictService.findByCityId(cityId);

        return ResponseEntity.ok(addDistrictDtoList);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/district/save")
    public ResponseEntity save(@RequestBody AddInsertDistrictDto addInsertDistrictDto) {

        AddDistrictDto addDistrictDto = addDistrictService.save(addInsertDistrictDto);

        return ResponseEntity.ok(addDistrictDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/neighborhood/save")
    public ResponseEntity save(@RequestBody AddInsertNeighborhoodDto addInsertNeighborhoodDto) {

        AddNeighborhoodDto addNeighborhoodDto = addNeighborhoodService.save(addInsertNeighborhoodDto);

        return ResponseEntity.ok(addNeighborhoodDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/neighborhood/update")
    public ResponseEntity update(@RequestBody AddNeighborhoodDto addNeighborhoodDto) {

        addNeighborhoodDto = addNeighborhoodService.update(addNeighborhoodDto);

        return ResponseEntity.ok(addNeighborhoodDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/neighborhood")
    public ResponseEntity AddNeighborhoodfindByDistrictId(Long districtId) {

        List<AddNeighborhoodDto> addNeighborhoodDtoList = addNeighborhoodService.findByDistrictId(districtId);

        return ResponseEntity.ok(addNeighborhoodDtoList);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/street/save")
    public ResponseEntity save(@RequestBody AddInsertStreetDto addInsertStreetDto) {

        AddStreetDto addStreetDto = addStreetService.save(addInsertStreetDto);

        return ResponseEntity.ok(addStreetDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/street/update")
    public ResponseEntity updateStreet(@RequestBody AddStreetDto addStreetDto) {

        addStreetDto = addStreetService.update(addStreetDto);

        return ResponseEntity.ok(addStreetDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/street")
    public ResponseEntity AddStreetfindByNeighborhoodId(Long neighborhoodId) {

        List<AddStreetDto> addStreetDtoList = addStreetService.findByNeighborhoodId(neighborhoodId);

        return ResponseEntity.ok(addStreetDtoList);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/address/save")
    public ResponseEntity save(@RequestBody AddInsertAddressDto addInsertAddressDto) {

        AddAddressDto addAddressDto = addAddressService.save(addInsertAddressDto);

        return ResponseEntity.ok(addAddressDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/address")
    public ResponseEntity AddAddressfindById(Long id) {

        AddAddressDto addAddressDto = addAddressService.findById(id);

        return ResponseEntity.ok(addAddressDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/address/delete")
    public ResponseEntity deleteAddress(Long id) {

        addAddressService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }

}
