package com.challenge.customer_service.application.util;

public class Constants {
public static final String URI_PARAMETER = "uri.parameter"; // Nuevo parámetro configurable
public static final String URI = System.getProperty(URI_PARAMETER, "http://default.example.com/api");
    public static final String PAGE_LENGTH = "page must be greater than or equal to 0";
    public static final String SIZE_LENGTH = "size must be between 1 and 100";
    public static final String CUSTOMER_REQUIRED = "customer is required";
    public static final String PERSON_REQUIRED = "person data is required";
    public static final String NAME_REQUIRED = "name must not be blank";
    public static final String GENDER_REQUIRED = "gender must not be null";
    public static final String IDENTIFICATION_REQUIRED = "identification must not be blank";
    public static final String ADDRESS_REQUIRED = "address must not be blank";
    public static final String PHONE_REQUIRED = "phone must not be blank";
    public static final String PASSWORD_REQUIRED = "password must not be blank";

    private Constants() {
    }
}
