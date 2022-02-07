package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<ServiceUser, Long> {

  List<ServiceUser> findByName(final String name);

  Optional<ServiceUser> findById(final String id);

  Optional<ServiceUser> findByNo(final Long no);

  Optional<ServiceUser> findByIdAndPassword(final String id, final String password);

}
