package com.sapient.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="USERS")
public class User {
    @Id
    private String email;
    private String password;
    @Column(name="is_active")
    private Boolean isActive;
}
