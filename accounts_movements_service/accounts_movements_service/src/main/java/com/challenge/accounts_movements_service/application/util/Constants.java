package com.challenge.accounts_movements_service.application.util;

public class Constants {

    public static final String ACCOUNT_REQUIRED = "account is required";
    public static final String ACCOUNT_ID_REQUIRED = "accountId is required";
    public static final String CUSTOMER_ID_REQUIRED = "customerId is required";
    public static final String ACCOUNT_NUMBER_REQUIRED = "accountNumber is required";
    public static final String TYPE_REQUIRED = "type is required";
    public static final String INITIAL_BALANCE_REQUIRED = "initialBalance must be >= 0";
    public static final String CURRENT_BALANCE_REQUIRED = "currentBalance must be >= 0";
    public static final String PAGE_MIN_ZERO = "page must be >= 0";
    public static final String SIZE_RANGE = "size must be between 1 and 100";

    public static final String MOVEMENT_REQUIRED = "movement is required";
    public static final String MOVEMENT_ID_REQUIRED = "movementId is required";
    public static final String DATE_REQUIRED = "date is required";
    public static final String VALUE_REQUIRED = "value is required";
    public static final String MOVEMENT_VALUE_POSITIVE = "movement value must be > 0";
    public static final String ACCOUNT_ID_CANNOT_CHANGE = "accountId cannot be changed";

    public static final String CLIENT_ID_REQUIRED = "clientId is required";
    public static final String START_DATE_REQUIRED = "startDate is required";
    public static final String END_DATE_REQUIRED = "endDate is required";
    public static final String END_DATE_BEFORE_START = "endDate must be >= startDate";

    private Constants() {
    }
}
