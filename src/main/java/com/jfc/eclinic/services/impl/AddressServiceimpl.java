/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.services.impl;

import com.jfc.eclinic.dao.AddressRepository;
import com.jfc.eclinic.dto.Address;
import com.jfc.eclinic.services.AddressService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author F
 */
public class AddressServiceimpl implements AddressService {

    private AddressRepository addressRepository;

    @Inject
    public AddressServiceimpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressServiceimpl() {
    }

    

    /*public Address findTheAddress(Address addressTo) throws Exception {
        List<Object> docs = (List<Object>) sqlRepository.findAll("Address.findAll");
        for (Object o : docs) {
            if (((Address) o).getCityId().getCityId().intValue() == addressTo.getCityId().getCityId().intValue()
                    && ((Address) o).getBuildingNumber() == addressTo.getBuildingNumber()
                    && ((Address) o).getStreetName().equals(addressTo.getStreetName())) {
                return (Address) o;
            }
        }

        return addressTo;
    }*/

 /* public String checkIfAddressExists(Address addressToMatch) throws Exception {
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
    }*/
    /*public void persistAddress(Address address) throws Exception {
        addressRepository.add(address);
    }

    public void editAddress(Address address) throws Exception {
        addressRepository.update(address);
    }*/

    @Override
    public List<Address> get() throws Exception {
        return addressRepository.findAll();
    }

    @Override
    public Address get(int id) throws Exception {
        return addressRepository.findById(id);
    }

    @Override
    public void update(Address value) throws Exception {
        addressRepository.update(value);
    }

    @Override
    public void create(Address value) throws Exception {
        addressRepository.add(value);
    }

    @Override
    public void delete(int id) throws Exception {
        addressRepository.remove(id);
    }
}
