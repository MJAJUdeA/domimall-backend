package io.mjaj.domimallbackend.component.commerce.io.gateway;

import io.mjaj.domimallbackend.component.commerce.io.repository.CommerceRepository;
import io.mjaj.domimallbackend.component.commerce.model.Commerce;
import io.mjaj.domimallbackend.component.commerce.service.CommerceGateway;
import io.mjaj.domimallbackend.component.shared.web.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Repository
public class CommerceGatewayImpl implements CommerceGateway {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String RESOURCE_NOT_FOUND = "Commerce not found";

    private final CommerceRepository commerceRepository;

    @Override
    public Commerce save(@NotNull Commerce commerceToCreate) {
        logger.debug("Begin save: commerceToCreate = {}", commerceToCreate);

        final Commerce commerceToBeCreated =
                commerceToCreate.toBuilder().createDate(LocalDateTime.now())
                        .updateDate(LocalDateTime.now())
                        .isActive(false)
                        .build();

        final Commerce commerceCreated = commerceRepository.save(commerceToBeCreated);

        logger.debug("End save: commerceCreated = {}", commerceCreated);

        return  commerceCreated;
    }

    @Override
    public Commerce findById(@NotNull Long id) {
        logger.debug("Begin findById: id = {}", id);

        Commerce commerceFound = commerceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(RESOURCE_NOT_FOUND));

        logger.debug("End findById: commerceFound = {}", commerceFound);

        return commerceFound;
    }
}
