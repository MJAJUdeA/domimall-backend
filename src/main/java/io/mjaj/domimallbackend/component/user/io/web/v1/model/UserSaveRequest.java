package io.mjaj.domimallbackend.component.user.io.web.v1.model;

import io.mjaj.domimallbackend.component.shared.constants.UserConstants;
import io.mjaj.domimallbackend.component.user.service.model.UserSaveCmd;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Generated
@Data
@Builder
public class UserSaveRequest {

    @Size(min = UserConstants.MIN_SIZE_DOCUMENT_ID, max = UserConstants.MAX_SIZE_DOCUMENT_ID,
            message = UserConstants.BAD_SIZE_DOCUMENT_ID_MESSAGE)
    @NotNull
    private String documentId;

    @Size(min = UserConstants.MIN_SIZE_NAMES, max = UserConstants.MAX_SIZE_NAMES,
            message = UserConstants.BAD_SIZE_NAMES_MESSAGE)
    @NotNull
    private String names;

    @Size(min = UserConstants.MIN_SIZE_LAST_NAMES, max = UserConstants.MAX_SIZE_LAST_NAMES,
            message = UserConstants.BAD_SIZE_LAST_NAMES_MESSAGE)
    @NotNull
    private String lastNames;

    @Email(message = UserConstants.INVALID_EMAIL_MESSAGE)
    @Column(unique = true)
    @NotNull
    private String email;

    @ToString.Exclude
    @Size(min = UserConstants.MIN_SIZE_PASSWORD, max = UserConstants.MAX_SIZE_PASSWORD,
            message = UserConstants.BAD_SIZE_PASSWORD_MESSAGE)
    @NotNull
    private String password;

    @Size(min = UserConstants.MIN_SIZE_PHONE, max = UserConstants.MAX_SIZE_PHONE,
            message = UserConstants.BAD_SIZE_PHONE_MESSAGE)
    private String phone;

    public static UserSaveCmd toModel(UserSaveRequest userToCreate) {
        return UserSaveCmd.builder().documentId(userToCreate.getDocumentId())
                .names(userToCreate.getNames())
                .lastNames(userToCreate.getLastNames())
                .email(userToCreate.getEmail())
                .password(userToCreate.getPassword())
                .phone(userToCreate.getPhone())
                .build();
    }
}
