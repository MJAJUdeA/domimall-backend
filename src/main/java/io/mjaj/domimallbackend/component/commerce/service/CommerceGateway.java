package io.mjaj.domimallbackend.component.commerce.service;

import io.mjaj.domimallbackend.component.commerce.model.Commerce;

import javax.validation.constraints.NotNull;

public interface CommerceGateway {

    Commerce save(@NotNull Commerce commerceToCreate);

    Commerce findById(@NotNull Long id);

}
