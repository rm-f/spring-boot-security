package com.example.security.web.serivce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class ServiceResponse<T> {

  private int code;
  private String message;
  private T data;

  @Override
  public String toString() {
    return "ServiceResponse{"
        + "code="
        + code
        + ", message='"
        + message
        + '\''
        + ", data="
        + data
        + '}';
  }
}
