package com.example.smartlink.dto;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class SmartLink implements Serializable {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String photo;
    private String title;
    private String url;
    private String price;
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usersl_id")
    private UserSl userSl;
    public SmartLink() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserSl getUserSl() {
        return userSl;
    }

    public void setUserSl(UserSl userSl) {
        this.userSl = userSl;
    }
}
