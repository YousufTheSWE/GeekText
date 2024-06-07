package com.example.geekText.profile;

import jakarta.persistence.*;


@Entity
@Table(name = "profiles")
public class Profiles {
    @Id
    @SequenceGenerator(
            name = "profile_sequence",
            sequenceName = "profile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_sequence"
    )
    private Long id;
    private String username;
    private String email;
    public Profiles() {
    }
    public Profiles(Long id,
                   String username,
                   String email
                   ) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Profiles(String username,
                   String email
                   ) {
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
