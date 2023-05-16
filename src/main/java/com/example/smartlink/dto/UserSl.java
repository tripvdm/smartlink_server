package com.example.smartlink.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "UserSl")
public class UserSl implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String login;
    @Column(unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SmartLink> smartLinks = new ArrayList<>();

    public UserSl() { }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SmartLink> getSmartLinks() {
        return smartLinks;
    }

    public void setSmartLinks(List<SmartLink> smartLinkSet) {
        this.smartLinks = smartLinkSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSl userSl = (UserSl) o;
        return Objects.equals(id, userSl.id) && Objects.equals(login, userSl.login) && Objects.equals(email, userSl.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email);
    }
}
