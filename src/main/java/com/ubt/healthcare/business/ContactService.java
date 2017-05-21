/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Contact;
import com.ubt.healthcare.dto.Person;

/**
 *
 * @author F
 */
public class ContactService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;

    public ContactService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

    private void persistMobileNumber(String contactValue, Person person) {

        Contact contact = new Contact();
        contact.setValue(contactValue);
        contact.setType("MOB");
        contact.setPersonId(person);
        sqlRepository.add(contact);
    }

    private void persistHomeNumber(String contactValue, Person person) {
        Contact contact = new Contact();
        contact.setValue(contactValue);
        contact.setType("HOME");
        contact.setPersonId(person);
        sqlRepository.add(contact);

    }

    private void persistWorkNumber(String contactValue, Person person) {
        Contact contact = new Contact();
        contact.setValue(contactValue);
        contact.setType("WORK");
        contact.setPersonId(person);
        sqlRepository.add(contact);

    }

    private void persistEmail(String contactValue, Person person) {
        Contact contact = new Contact();
        contact.setValue(contactValue);
        contact.setType("EMAIL");
        contact.setPersonId(person);
        sqlRepository.add(contact);

    }

    public void persistContact(Person person, String contactType, String value) {
        if (!(value == null || value.trim().isEmpty())) {
            if (contactType.equals("EMAIL")) {
                persistEmail(value, person);
            }
            else if (contactType.equals("HOME")) {
                persistHomeNumber(value, person);
            }
            else if (contactType.equals("WORK")) {
                persistWorkNumber(value, person);
            }
            else if (contactType.equals("MOB")) {
                persistMobileNumber(value, person);
            }
        }

    }
}
