package io.mjaj.domimallbackend.component.shared.web.exception;

public class NotExistOnSICException extends ConflictException {
    private static final String DESCRIPTION = "Must exist on SIC";

    public NotExistOnSICException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
