package io.mjaj.domimallbackend.component.user.service.model;

import io.mjaj.domimallbackend.component.shared.constants.UserConstants;
import io.mjaj.domimallbackend.component.user.model.User;
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
public class UserSaveCmd {

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

    public static User toModel(UserSaveCmd userToCreateCmd) {
        return User.builder().documentId(userToCreateCmd.getDocumentId())
                .names(userToCreateCmd.getNames())
                .lastNames(userToCreateCmd.getLastNames())
                .email(userToCreateCmd.getEmail())
                .password(userToCreateCmd.getPassword())
                .phone(userToCreateCmd.getPhone())
                .build();
    }
}
