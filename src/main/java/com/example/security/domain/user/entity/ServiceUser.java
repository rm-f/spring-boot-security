package com.example.security.domain.user.entity;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Table(name = "users")
@SequenceGenerator(
    name = "USERS_NO_GENERATOR",
    sequenceName = "SQ_USERS_USERNO",
    initialValue = 1,
    allocationSize = 1
)
public class ServiceUser {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_NO_GENERATOR")
  private Long userNo;

  @NotNull
  @Column(nullable = false, unique = true)
  private String userId;

  @Column(nullable = false)
  private String userName;
  @Column(nullable = false)
  private String email;
  private String password;
  private boolean enabled;
  @ColumnDefault("USER")
  private String userRole;

}
