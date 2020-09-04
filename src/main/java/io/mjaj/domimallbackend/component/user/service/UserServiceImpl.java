package io.mjaj.domimallbackend.component.user.service;

import io.mjaj.domimallbackend.component.user.model.User;
import io.mjaj.domimallbackend.component.user.service.model.UserSaveCmd;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PasswordEncoder passwordEncoder;

    private final UserGateway userGateway;

    @Override
    public User create(@NotNull UserSaveCmd userToCreateCmd) {
        logger.debug("Begin create: userToCreateCmd = {}", userToCreateCmd);

        final User userToCreate = UserSaveCmd.toModel(userToCreateCmd);

        userToCreate.setPassword(passwordEncoder.encode(userToCreateCmd.getPassword()));

        final User userCreated = userGateway.save(userToCreate);

        logger.debug("End create: userCreated = {}", userCreated);

        return userCreated;
    }
}
