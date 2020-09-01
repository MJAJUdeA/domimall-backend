package io.mjaj.domimallbackend.component.commerce.io.repository;

import io.mjaj.domimallbackend.component.commerce.model.Commerce;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommerceRepository extends PagingAndSortingRepository<Commerce, Long> {
}
