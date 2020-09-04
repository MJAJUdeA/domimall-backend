package io.mjaj.domimallbackend.component.user.service;

import io.mjaj.domimallbackend.component.user.model.User;

import javax.validation.constraints.NotNull;

public interface UserGateway {

    User save(@NotNull User userToCreate);

}
