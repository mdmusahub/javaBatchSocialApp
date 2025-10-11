package com.mecaps.socialApp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
//    @NonNull
    private String userName;
//    @NonNull
    @Column(unique = false, nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;


}
