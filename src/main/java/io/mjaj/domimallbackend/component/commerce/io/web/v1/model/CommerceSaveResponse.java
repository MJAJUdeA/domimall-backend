package io.mjaj.domimallbackend.component.commerce.io.web.v1.model;

import io.mjaj.domimallbackend.component.commerce.model.Commerce;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommerceSaveResponse {

    private Long id;

    private String documentType;

    private String documentId;

    private String tradeName;

    private String legalName;

    private String email;

    private String phone;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public static CommerceSaveResponse fromModel(Commerce commerce){
        return CommerceSaveResponse.builder().id(commerce.getId())
                .documentType(commerce.getDocumentType())
                .documentId(commerce.getDocumentId())
                .tradeName(commerce.getTradeName())
                .legalName(commerce.getLegalName())
                .email(commerce.getEmail())
                .phone(commerce.getPhone())
                .createDate(commerce.getCreateDate())
                .updateDate(commerce.getUpdateDate())
                .build();
    }
}
