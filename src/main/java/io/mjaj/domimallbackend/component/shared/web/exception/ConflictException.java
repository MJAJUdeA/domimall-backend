package io.mjaj.domimallbackend.component.shared.web.exception;

public class ConflictException extends RuntimeException {

    private static final String Description = "Conflict Exception (409)";

    public ConflictException(String detail){
        super(Description + ". " + detail);
    }
}
