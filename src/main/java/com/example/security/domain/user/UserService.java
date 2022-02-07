package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;

public interface UserService {
  ServiceUser regist(final LoginUser loginUser);
}
