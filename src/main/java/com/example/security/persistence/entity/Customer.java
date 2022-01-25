package com.example.security.persistence.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long no;

  private String id;
  private String name;
  private String password;

  @Override
  public String toString() {
    return "Customer{" +
            "no=" + no +
            ", id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
