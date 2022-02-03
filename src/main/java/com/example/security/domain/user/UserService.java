package com.example.security.domain.user;

import com.example.security.domain.user.entity.User;

public interface UserService {
  User regist(final LoginUser loginUser);
}
