package com.example.security.web.serivce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class ServiceResponse<T> {

  @Default
  private int code = 200;
  @Default
  private String message = "success";
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
