package io.mjaj.domimallbackend.component.commerce.service;

import io.mjaj.domimallbackend.component.commerce.model.Commerce;
import io.mjaj.domimallbackend.component.commerce.service.model.CommerceSaveCmd;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
@Transactional
public class CommerceServiceImpl implements CommerceService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CommerceGateway commerceGateway;

    @Override
    public Commerce create(@NotNull CommerceSaveCmd commerceToCreateCmd) {
        logger.debug("Begin create: commerceToCreateCmd = {}", commerceToCreateCmd);

        final Commerce commerceToCreate = CommerceSaveCmd.toModel(commerceToCreateCmd);

        final Commerce commerceCreated = commerceGateway.save(commerceToCreate);

        logger.debug("End create: commerceCreated = {}", commerceCreated);

        return commerceCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public Commerce findById(@NotNull Long id) {
        logger.debug("Begin findById: id = {}", id);

        Commerce commerceFound = commerceGateway.findById(id);

        logger.debug("End findById: commerceFound = {}", commerceFound);

        return commerceFound;
    }
}
