package com.example.security.domain.mapper;

import com.example.security.component.mapper.GenericMapper;
import com.example.security.domain.user.LoginUser;
import com.example.security.domain.user.entity.ServiceUser;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LoginUserMapper extends GenericMapper<LoginUser, ServiceUser> {}
