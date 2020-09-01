package io.mjaj.domimallbackend.component.commerce.model;

import io.mjaj.domimallbackend.component.shared.constants.CommerceConstants;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "commerces")
@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Commerce implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

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
    @Column(unique = true)
    @NotNull
    private String email;

    @Size(min = CommerceConstants.MIN_SIZE_PHONE, max = CommerceConstants.MAX_SIZE_PHONE,
            message = CommerceConstants.BAD_SIZE_PHONE_MESSAGE)
    @NotNull
    private String phone;

    @NotNull
    private Boolean isActive;

    @NotNull
    private LocalDateTime createDate;

    @NotNull
    private LocalDateTime updateDate;
}
