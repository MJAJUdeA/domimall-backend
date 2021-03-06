package io.mjaj.domimallbackend.component.user.io.gateway;

import io.mjaj.domimallbackend.component.user.io.repository.UserRepository;
import io.mjaj.domimallbackend.component.user.model.User;
import io.mjaj.domimallbackend.component.user.service.UserGateway;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserRepository userRepository;

    @Override
    public User save(@NotNull User userToCreate) {
        logger.debug("Begin save: userToCreate = {}", userToCreate);

        final User userToBeCreated = userToCreate.toBuilder()
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .isActive(true)
                .build();

        final User userCreated = userRepository.save(userToBeCreated);

        logger.debug("End save: userCreated = {}", userCreated);
        return userCreated;
    }
}
