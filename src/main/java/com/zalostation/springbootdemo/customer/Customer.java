package com.zalostation.springbootdemo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name field is required")
    private String name;

    @NotBlank(message = "password field is required")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "email field is required")
    @Email()
    private String email;

    @JsonProperty("customer_id")
    public Long getId() {
        return id;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

}
