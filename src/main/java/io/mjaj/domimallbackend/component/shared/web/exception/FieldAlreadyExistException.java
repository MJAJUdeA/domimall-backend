package io.mjaj.domimallbackend.component.shared.web.exception;

public class FieldAlreadyExistException extends ConflictException {

    private static final String DESCRIPTION = "Field Already Exist";

    public FieldAlreadyExistException(String detail){
        super(DESCRIPTION + ". " + detail);
    }
}
