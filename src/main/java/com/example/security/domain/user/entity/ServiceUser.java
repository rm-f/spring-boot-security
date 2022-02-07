package com.example.security.domain.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class ServiceUser {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long no;

  @Column(nullable = false, unique = true)
  private String id;

  @Column(nullable = false)
  private String name;
  private String password;
  private boolean enabled;
  @ColumnDefault("USER")
  private String role;

}
