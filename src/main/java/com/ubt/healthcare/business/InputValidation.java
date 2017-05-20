/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import java.util.regex.Pattern;

/**
 *
 * @author F
 */
public class InputValidation {

    private static final String TYPE_YOUR_ID = "Type you Personal ID";
    private static final String TYPE_YOUR_FIRST_NAME = "Type you First Name";
    private static final String TYPE_ONLY_NUMBERS = "You shoud type only numbers";
    private static final String TYPE_ONLY_CHARACTERS = "You shoud type only characters";
    private static final String VALID = "Valid";
    private static final Pattern NOT_NUMBER_PATTERN = Pattern.compile("[^0-9]");
    private static final Pattern NOT_CHARACTER_PATTERN = Pattern.compile("[^A-Za-z]");

    public boolean validateInput(String msg) {
        return !msg.trim().isEmpty();
    }

    public String validatePersonID(String personId) {
        if (personId == null || personId.trim().isEmpty()) {
            return TYPE_YOUR_ID;
        }
        if (NOT_NUMBER_PATTERN.matcher(personId).matches()) {
            return TYPE_ONLY_NUMBERS;
        }
        return VALID;
    }

    public String validatePersonFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            return TYPE_YOUR_FIRST_NAME;
        }
        if (NOT_CHARACTER_PATTERN.matcher(firstName).matches()) {
            return TYPE_ONLY_CHARACTERS;
        }
        return VALID;
    }
}
