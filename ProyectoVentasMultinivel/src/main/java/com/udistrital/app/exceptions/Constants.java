package com.udistrital.app.exceptions;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String REGION_NOT_FOUND_MESSAGE = "No user found with the id provided";
    public static final String INVENTARIO_NOT_FOUND_MESSAGE = "No inventary found with the idInventory provided";
    public static final String CLIENT_NOT_FOUND_MESSAGE = "No client found with the idClient provided";

    public static final String PERIOD_NOT_FOUND_MESSAGE = "No period found with the idPeriod provided";

}
