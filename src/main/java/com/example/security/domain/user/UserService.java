package com.example.security.domain.user;

import com.example.security.domain.user.entity.ServiceUser;
import com.example.security.domain.user.form.RegistForm;

public interface UserService {
  ServiceUser regist(final RegistForm registForm);

  ServiceUser getServiceUser(final long no);
}
