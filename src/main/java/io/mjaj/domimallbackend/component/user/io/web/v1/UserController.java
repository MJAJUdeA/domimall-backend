package io.mjaj.domimallbackend.component.user.io.web.v1;

import io.mjaj.domimallbackend.component.user.io.web.v1.model.UserSaveRequest;
import io.mjaj.domimallbackend.component.user.model.User;
import io.mjaj.domimallbackend.component.user.service.UserService;
import io.mjaj.domimallbackend.component.user.service.model.UserSaveCmd;
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
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Void> create(@Valid @NotNull @RequestBody UserSaveRequest userToCreate){
        logger.debug("Begin create: userToCreate = {}", userToCreate);

        final UserSaveCmd userToCreateCmd = UserSaveRequest.toModel(userToCreate);

        final User userCreated = userService.create(userToCreateCmd);

        URI location = fromUriString("/api/v1/users").path("/{id}")
                .buildAndExpand(userCreated.getId()).toUri();

        logger.debug("End create: userCreated = {}", userCreated);

        return ResponseEntity.created(location).build();
    }
}
