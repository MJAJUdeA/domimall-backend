package io.mjaj.domimallbackend.component.commerce.io.web.v1.model;

import io.mjaj.domimallbackend.component.shared.constants.CommerceConstants;
import io.mjaj.domimallbackend.component.commerce.service.model.CommerceSaveCmd;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Generated
@Data
@Builder
public class CommerceSaveRequest {

    @Size(min = CommerceConstants.MIN_SIZE_DOCUMENT_TYPE, max = CommerceConstants.MAX_SIZE_DOCUMENT_TYPE,
            message = CommerceConstants.BAD_SIZE_DOCUMENT_TYPE_MESSAGE)
    @NotNull
    private String documentType;

    @Size(min = CommerceConstants.MIN_SIZE_DOCUMENT_ID, max = CommerceConstants.MAX_SIZE_DOCUMENT_ID,
            message = CommerceConstants.BAD_SIZE_DOCUMENT_ID_MESSAGE)
    @NotNull()
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

    public static CommerceSaveCmd toModel(CommerceSaveRequest commerceToCreate){
        return CommerceSaveCmd.builder().documentType(commerceToCreate.getDocumentType())
                .documentId(commerceToCreate.getDocumentId())
                .tradeName(commerceToCreate.getTradeName())
                .legalName(commerceToCreate.getLegalName())
                .email(commerceToCreate.getEmail())
                .phone(commerceToCreate.getPhone())
                .build();
    }
}
