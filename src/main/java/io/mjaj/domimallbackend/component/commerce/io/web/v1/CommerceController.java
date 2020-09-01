package io.mjaj.domimallbackend.component.commerce.io.web.v1;

import io.mjaj.domimallbackend.component.commerce.io.web.v1.model.CommerceSaveRequest;
import io.mjaj.domimallbackend.component.commerce.model.Commerce;
import io.mjaj.domimallbackend.component.commerce.service.CommerceService;
import io.mjaj.domimallbackend.component.commerce.service.model.CommerceSaveCmd;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@RequestMapping(path = "/api/v1/commerces", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CommerceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CommerceService commerceService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Void> create(@Valid @NotNull @RequestBody CommerceSaveRequest commerceToCreate){
        logger.debug("Begin create: commerceToCreate = {}", commerceToCreate);

        final CommerceSaveCmd commerceToCreateCmd = CommerceSaveRequest.toModel(commerceToCreate);

        final Commerce commerceCreated = commerceService.create(commerceToCreateCmd);

        URI location = fromUriString("/api/v1/commerces").path("/{id}")
                .buildAndExpand(commerceCreated.getId()).toUri();


        logger.debug("End create: commerceCreated = {}", commerceCreated);

        return ResponseEntity.created(location).build();
    }
}
