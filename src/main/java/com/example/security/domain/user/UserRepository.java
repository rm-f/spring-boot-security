package com.example.security.domain.user;

import com.example.security.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findByName(final String name);

  User findById(final String id);

  User findByNo(final Long no);

}
