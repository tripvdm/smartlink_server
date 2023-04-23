package com.example.smartlink.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class SmartLink implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String photo;
    private String title;
    private String url;
    private String price;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name="usersl_id", nullable = false)
    private UserSl userSl;

    public SmartLink() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartLink smartLink = (SmartLink) o;
        return url.equals(smartLink.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
