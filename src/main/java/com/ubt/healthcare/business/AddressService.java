/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Address;
import java.util.List;

/**
 *
 * @author F
 */
public class AddressService {

    private SQLRepository sqlRepository;

    public AddressService() {
        sqlRepository = new SQLRepository();
    }

    public Address findTheAddress(Address addressTo)throws Exception {
        List<Object> docs = (List<Object>) sqlRepository.findAll("Address.findAll");
        for (Object o : docs) {
            if (((Address) o).getCityId().getCityId().intValue() == addressTo.getCityId().getCityId().intValue()
                    && ((Address) o).getBuildingNumber() == addressTo.getBuildingNumber()
                    && ((Address) o).getStreetName().equals(addressTo.getStreetName())) {
                return (Address) o;
            }
        }

        return addressTo;
    }

    public String checkIfAddressExists(Address addressToMatch)throws Exception {
        String msg = "Save";
        List<Object> address = (List<Object>) sqlRepository.findAll("Address.findAll");
        for (Object o : address) {
            if (((Address) o).getCityId().getCityId().intValue() == addressToMatch.getCityId().getCityId().intValue()
                    && ((Address) o).getBuildingNumber() == addressToMatch.getBuildingNumber()
                    && ((Address) o).getStreetName().equals(addressToMatch.getStreetName())) {
                return "Exist";
            }
        }

        return msg;
    }
    
    public void persistAddress(Address address)throws Exception {
        sqlRepository.add(address);
    }
    
       public void editAddress(Address address)throws Exception {
        sqlRepository.update(address);
    }
}
