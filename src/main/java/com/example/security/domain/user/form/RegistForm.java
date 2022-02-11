package com.example.security.domain.user.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistForm {

  @NotBlank(message = "아이디를 입력해주세요.")
  @Size(min = 3, max = 255, message = "유저아이디는 3자리이상 255이하 가능합니다.")
  private String userId;

  @NotBlank(message = "이름을 입력해주세요.")
  private String userName;

  @NotBlank(message = "패스워드는 12자이상 입력해주세요.")
  @Size(min = 12, max = 128, message = "비밀번호는 12자리이상 128자리이하 가능합니다.")
  private String password;

  @Email(message = "이메일을 입력해주세요.")
  private String email;
}
