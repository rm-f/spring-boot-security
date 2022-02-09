package com.example.security.domain.mapper;

import com.example.security.component.mapper.GenericMapper;
import com.example.security.domain.user.entity.ServiceUser;
import com.example.security.domain.user.form.RegistForm;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegistFormToServiceUserMapper extends GenericMapper<RegistForm, ServiceUser> {}
