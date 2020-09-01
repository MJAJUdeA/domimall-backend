package io.mjaj.domimallbackend.component.commerce.service;

import io.mjaj.domimallbackend.component.commerce.model.Commerce;
import io.mjaj.domimallbackend.component.commerce.service.model.CommerceSaveCmd;

import javax.validation.constraints.NotNull;

public interface CommerceService {

    Commerce create(@NotNull CommerceSaveCmd commerceToCreateCmd);
}
