package com.scm.backend.ContactManager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_contacts")
public class Contact {
    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter valid email address")
    private String email;

    private String phoneNumber;
    private String address;

    @Column(length = 1000)
    private String picture;

    @Lob
    private String description;

    private boolean favourite = false;
    private String websiteLink;
    private String linkedInLink;
    private String instagramLink;
    private String cloudinaryImagePublicId;

    @ManyToOne
    private User user;
}
