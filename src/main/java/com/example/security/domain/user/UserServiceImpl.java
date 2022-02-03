package com.example.security.domain.user;

import com.example.security.component.mapper.LoginUserMapper;
import com.example.security.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  final UserRepository userRepository;
  final LoginUserMapper loginUserMapper;

  @Override
  public User regist(LoginUser loginUser) {
    User regist = userRepository.save(loginUserMapper.toEntity(loginUser));
    return regist;
  }
}
