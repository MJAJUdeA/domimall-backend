package io.mjaj.domimallbackend.component.commerce.service.model;

import io.mjaj.domimallbackend.component.shared.constants.CommerceConstants;
import io.mjaj.domimallbackend.component.commerce.model.Commerce;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Generated
@Data
@Builder
public class CommerceSaveCmd {

    @Size(min = CommerceConstants.MIN_SIZE_DOCUMENT_TYPE, max = CommerceConstants.MAX_SIZE_DOCUMENT_TYPE,
            message = CommerceConstants.BAD_SIZE_DOCUMENT_TYPE_MESSAGE)
    @NotNull
    private String documentType;

    @Size(min = CommerceConstants.MIN_SIZE_DOCUMENT_ID, max = CommerceConstants.MAX_SIZE_DOCUMENT_ID,
            message = CommerceConstants.BAD_SIZE_DOCUMENT_ID_MESSAGE)
    @NotNull
    private String documentId;

    @Size(min = CommerceConstants.MIN_SIZE_TRADE_NAME, max = CommerceConstants.MAX_SIZE_TRADE_NAME,
            message = CommerceConstants.BAD_SIZE_TRADE_NAME_MESSAGE)
    @NotNull
    private String tradeName;

    @Size(min = CommerceConstants.MIN_SIZE_LEGAL_NAME, max = CommerceConstants.MAX_SIZE_LEGAL_NAME,
            message = CommerceConstants.BAD_SIZE_LEGAL_NAME_MESSAGE)
    @NotNull
    private String legalName;

    @Email(message = CommerceConstants.INVALID_EMAIL_MESSAGE)
    @NotNull
    private String email;

    @Size(min = CommerceConstants.MIN_SIZE_PHONE, max = CommerceConstants.MAX_SIZE_PHONE,
            message = CommerceConstants.BAD_SIZE_PHONE_MESSAGE)
    @NotNull
    private String phone;

    public static Commerce toModel(CommerceSaveCmd commerceToCreateCmd){
        return Commerce.builder().documentType(commerceToCreateCmd.getDocumentType())
                .documentId(commerceToCreateCmd.getDocumentId())
                .tradeName(commerceToCreateCmd.getTradeName())
                .legalName(commerceToCreateCmd.getLegalName())
                .email(commerceToCreateCmd.getEmail())
                .phone(commerceToCreateCmd.phone)
                .build();

    }
}
