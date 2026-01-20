package com.scm.backend.ContactManager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    @NotBlank(message = "User is required")
    private String name;

    @Column(unique = true, nullable = true)
    private String email;

    private String Password;

    @Lob               // Lob is used for unlimited characters to Store
    private String about;

    @Column(length = 1000)
    private String profilePicture;
    private String phoneNumber;
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF;
    private String emailToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contact> contacts = new LinkedHashSet<>();
}
