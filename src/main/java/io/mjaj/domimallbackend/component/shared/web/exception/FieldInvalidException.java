package io.mjaj.domimallbackend.component.shared.web.exception;

public class FieldInvalidException extends BadRequestException {

    private static final String DESCRIPTION = "Field Invalid Exception";

    public FieldInvalidException(String detail){
        super(DESCRIPTION + " ." + detail);
    }
}
