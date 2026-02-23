package com.simonpeg.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="Account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
}
