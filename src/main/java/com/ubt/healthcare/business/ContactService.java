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
import java.util.List;

/**
 *
 * @author F
 */
public class ContactService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private static final String EMAIL = "EMAIL";
    private static final String HOME = "HOME";
    private static final String WORK = "WORK";
    private static final String MOB = "MOB";

    public ContactService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

    private void persist(String contactValue, Person person, String type) {
        Contact contact = new Contact();
        contact.setValue(contactValue);
        contact.setType(type);
        contact.setPersonId(person);
        sqlRepository.add(contact);

    }

    public void editContact(String contactValue) {
        Contact contact = findContact(contactValue);
        contact.setValue(contactValue);
        sqlRepository.update(contact);

    }

    public void persistContact(Person person, String contactType, String value) {
        if (!(value == null || value.trim().isEmpty())) {
            if (contactType.equals(EMAIL)) {
                persist(value, person, EMAIL);
            } else if (contactType.equals(HOME)) {
                persist(value, person, HOME);
            } else if (contactType.equals(WORK)) {
                persist(value, person, WORK);
            } else if (contactType.equals(MOB)) {
                persist(value, person, MOB);
            }
        }

    }

    public Contact findContact(String value) {
        List<Contact> findAll = (List<Contact>) (Object) sqlRepository.findAll("Contact.findAll");
        for (Contact contact : findAll) {
            if (contact.getValue().equals(value)) {
                return contact;
            }
        }
        return null;
    }
}
