package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<ServiceUser, Long> {

  List<ServiceUser> findByUserName(final String userName);

  Optional<ServiceUser> findByUserId(final String userId);

  Optional<ServiceUser> findByUserNo(final Long userNo);

  Optional<ServiceUser> findByUserIdAndPassword(final String userId, final String password);

}
