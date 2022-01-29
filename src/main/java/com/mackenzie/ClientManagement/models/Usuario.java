package com.mackenzie.ClientManagement.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@ToString
public class Usuario {

    @Id
    @Getter @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter @Setter
    @Column(name = "name")
    private String name;

    @Getter @Setter
    @Column(name = "last")
    private String last;

    @Getter @Setter
    @Column(name = "email")
    private String email;

    @Getter @Setter
    @Column(name = "phone")
    private String phone;

    @Getter @Setter
    @Column(name = "pass")
    private String pass;

    /*@Getter @Setter
    @Column(name = "balance")
    private double balance;*/


}
