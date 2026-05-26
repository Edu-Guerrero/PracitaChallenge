package com.challenge.customer_service.infrastructure.utils;

public class Constants {

    public static final String IN = "|---> ";
    public static final String OUT = "<---| ";
    public static final String ACTION_CREATE = "[Create] ";
    public static final String ACTION_UPDATE = "[Update] ";
    public static final String ACTION_DELETE = "[Delete] ";
    public static final String ACTION_GET_BY_ID = "[GetById] ";
    public static final String ACTION_LIST = "[List] ";
    public static final String MSG_VALIDATION_FAILED = "Validation failed";
    public static final String MSG_INVALID_REQUEST_PAYLOAD = "Invalid request payload";
    public static final String MSG_UNEXPECTED_ERROR = "Unexpected error";
    public static final String MSG_CONFLICT_CURRENT_STATE = "Conflict with current state";
    public static final String MSG_CUSTOMER_ID_REQUIRED_FOR_UPDATE = "customer.id is required for update";
    public static final String MSG_CUSTOMER_NOT_FOUND_PREFIX = "Customer not found: ";
    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_SIZE = 20;
    public static final String PATH_API_V1_CUSTOMERS = "/api/v1/customers";


    private Constants() {
    }

}
