package io.mjaj.domimallbackend.component.user.service;

import io.mjaj.domimallbackend.component.user.model.User;
import io.mjaj.domimallbackend.component.user.service.model.UserSaveCmd;

import javax.validation.constraints.NotNull;

public interface UserService {

    User create(@NotNull UserSaveCmd userToCreateCmd);
}
