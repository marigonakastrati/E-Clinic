/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.util;

import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author F
 */
public class InputValidation {

    private static final String TYPE_YOUR_ID = "Type your Personal ID";
    private static final String TYPE_YOUR_ADDRESS = "Type your Address";
    private static final String TYPE_YOUR_BUILDING_NUMBER = "Type your Building Number";
    private static final String TYPE_YOUR_PHONE_NUMBER = "Type your Phone Number";
    private static final String TYPE_YOUR_BIRTH_DAY = "Type your BirthDay";
    private static final String TYPE_YOUR_EMAIL = "Type your Email";
    private static final String TYPE_COUNTRY_NAME = "Type country name";
    private static final String TYPE_CITY_NAME = "Type city name";
    private static final String TYPE_ZIP_CODE = "Type zip code";
    private static final String TYPE_USER_NAME = "Type user name";
    private static final String TYPE_PASSWORD = "Type password";
    private static final String TYPE_YOUR_FIRST_NAME = "Type you First Name";
    private static final String TYPE_YOUR_LAST_NAME = "Type you Last Name";
    private static final String TYPE_ONLY_NUMBERS = "You shoud type only numbers";
    private static final String TYPE_YUOR_EMAIL_PROPERLY = "You shoud type your email in proper format";
    private static final String TYPE_MIN_PHONE_NUMBERS = "You shoud type proper phone numbers";
    private static final String TYPE_ONLY_NUMBERS_CHARACTERS = "You shoud type only characters or numbers";
    private static final String TYPE_ONLY_CHARACTERS = "You shoud type only characters";
    private static final String END_DATE_BEFORE_START_DATE = "End date must not be before the start date";
    private static final String END_DATE_SAME_WITH_START_DATE = "End date must not be same with the start date";
    private static final String BIRTH_DATE_NEWER_THEN_TODAY = "Birth date must be older than today";
    private static final String VALID = "Valid";
    private static final Pattern NOT_NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private static final Pattern NOT_CHARACTER_PATTERN = Pattern.compile("[A-Za-z\\s]+");
    private static final Pattern NOT_CHARACTER_NOT_NUMBER_PATTERN = Pattern.compile("[A-Za-z0-9\\s]+");
    private static final Pattern NOT_EMAIL_FORMAT_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    public boolean validateInput(String msg) {
        return !msg.trim().isEmpty();
    }

    public String validatePersonID(String personId) {
        if (personId == null || personId.trim().isEmpty()) {
            return TYPE_YOUR_ID;
        }
        if (!(NOT_NUMBER_PATTERN.matcher(personId).matches())) {
            return TYPE_ONLY_NUMBERS;
        }
        return VALID;
    }

    public String validatePersonFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            return TYPE_YOUR_FIRST_NAME;
        }
        if (!(NOT_CHARACTER_PATTERN.matcher(firstName).matches())) {
            return TYPE_ONLY_CHARACTERS;
        }
        return VALID;
    }

    public String validatePersonLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            return TYPE_YOUR_LAST_NAME;
        }
        if (!(NOT_CHARACTER_PATTERN.matcher(lastName).matches())) {
            return TYPE_ONLY_CHARACTERS;
        }
        return VALID;
    }

    public String validatePersonDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth == null) {
            return TYPE_YOUR_BIRTH_DAY;
        };
        Date todayDate = new Date();
        if (dateOfBirth.compareTo(todayDate) == 1) {
            return BIRTH_DATE_NEWER_THEN_TODAY;
        }
        return VALID;
    }

    public String validateEducationDateStartEnd(Date dateStart, Date dateEnd) {
        if (dateStart.compareTo(dateEnd) == 0) {
            return END_DATE_SAME_WITH_START_DATE;
        }
        if (dateStart.compareTo(dateEnd) == 1) {
            return END_DATE_BEFORE_START_DATE;
        }
        return VALID;
    }

    public String validateAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            return TYPE_YOUR_ADDRESS;
        }
        if (!(NOT_CHARACTER_NOT_NUMBER_PATTERN.matcher(address).matches())) {
            return TYPE_ONLY_NUMBERS_CHARACTERS;
        }
        return VALID;
    }

    public String validateBuildingNumber(String buildingNumber) {
        if (buildingNumber == null || buildingNumber.trim().isEmpty()) {
            return TYPE_YOUR_BUILDING_NUMBER;
        }
        if (!(NOT_NUMBER_PATTERN.matcher(buildingNumber).matches())) {
            return TYPE_ONLY_NUMBERS;
        }
        return VALID;
    }

    public String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return TYPE_YOUR_PHONE_NUMBER;
        }
        if (!(NOT_NUMBER_PATTERN.matcher(phoneNumber).matches())) {
            return TYPE_ONLY_NUMBERS;
        }
        if (phoneNumber.trim().length() < 6) {
            return TYPE_MIN_PHONE_NUMBERS;
        }
        return VALID;
    }

    public String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return TYPE_YOUR_EMAIL;
        }
        if (!(NOT_EMAIL_FORMAT_PATTERN.matcher(email).matches())) {
            return TYPE_YUOR_EMAIL_PROPERLY;
        }
        return VALID;
    }

    public String validateCountryName(String countrName) {
        if (countrName == null || countrName.trim().isEmpty()) {
            return TYPE_COUNTRY_NAME;
        }
        if (!(NOT_CHARACTER_PATTERN.matcher(countrName).matches())) {
            return TYPE_ONLY_CHARACTERS;
        }
        return VALID;
    }

    public String validateCityName(String cityName) {
        if (cityName == null || cityName.trim().isEmpty()) {
            return TYPE_CITY_NAME;
        }
        if (!(NOT_CHARACTER_PATTERN.matcher(cityName).matches())) {
            return TYPE_ONLY_CHARACTERS;
        }
        return VALID;
    }

    public String validateZipCode(String cityName) {
        if (cityName == null || cityName.trim().isEmpty()) {
            return TYPE_ZIP_CODE;
        }
        if (!(NOT_NUMBER_PATTERN.matcher(cityName).matches())) {
            return TYPE_ONLY_NUMBERS;
        }
        return VALID;
    }

    public String validateHomeNumber(String phoneNumber) {
        if (!(NOT_NUMBER_PATTERN.matcher(phoneNumber).matches())) {
            return TYPE_ONLY_NUMBERS;
        }
        if (phoneNumber.trim().length() < 6) {
            return TYPE_MIN_PHONE_NUMBERS;
        }
        return VALID;
    }

    public String validateUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            return TYPE_USER_NAME;
        }
        if (!(NOT_NUMBER_PATTERN.matcher(userName).matches())) {
            return TYPE_ONLY_NUMBERS;
        }
        return VALID;
    }

    public String validatePassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            return TYPE_PASSWORD;
        }

        return VALID;
    }
}
