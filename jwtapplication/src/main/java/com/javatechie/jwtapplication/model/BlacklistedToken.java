package com.javatechie.jwtapplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jwt_blacklist")
public class BlacklistedToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    public BlacklistedToken() {}
    public BlacklistedToken(String token) {
        this.token = token;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
