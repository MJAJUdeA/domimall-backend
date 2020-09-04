package io.mjaj.domimallbackend.component.user.io.repository;

import io.mjaj.domimallbackend.component.user.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
