package io.mjaj.domimallbackend.component.shared.constants;

public class UserConstants {

    public static final int MIN_SIZE_DOCUMENT_ID = 3;
    public static final int MAX_SIZE_DOCUMENT_ID = 80;
    public static final String BAD_SIZE_DOCUMENT_ID_MESSAGE = "Document id must be between 3 and 80 characters";

    public static final int MIN_SIZE_NAMES = 2;
    public static final int MAX_SIZE_NAMES = 80;
    public static final String BAD_SIZE_NAMES_MESSAGE = "Names must be between 2 and 80 characters";

    public static final int MIN_SIZE_LAST_NAMES = 2;
    public static final int MAX_SIZE_LAST_NAMES = 80;
    public static final String BAD_SIZE_LAST_NAMES_MESSAGE = "Last names must be between 2 and 80 characters";

    public static final String INVALID_EMAIL_MESSAGE = "Email must be a valid email";

    public static final int MIN_SIZE_PASSWORD = 8;
    public static final int MAX_SIZE_PASSWORD = 70;
    public static final String BAD_SIZE_PASSWORD_MESSAGE = "Password must be between 8 and 70 characters";


    public static final int MIN_SIZE_PHONE = 6;
    public static final int MAX_SIZE_PHONE = 80;
    public static final String BAD_SIZE_PHONE_MESSAGE = "Phone must be between 6 and 80 characters";
}
