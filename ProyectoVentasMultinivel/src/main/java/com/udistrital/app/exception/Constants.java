package com.udistrital.app.exception;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";

    public static final String REGION_NOT_FOUND_MESSAGE = "No user found with the id provided";


}
