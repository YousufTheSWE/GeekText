package com.example.geekText.User;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public User(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }


}

