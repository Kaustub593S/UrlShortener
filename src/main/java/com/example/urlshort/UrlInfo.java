package com.example.urlshort;

import jakarta.persistence.*;

@Entity
@Table(name = "urlinfo")
public class UrlInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long urlId;

    @Column(
            unique = true,
            nullable = false
    )
    private String shortCode;

    @Column(nullable = false)
    private String originalurl;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getOriginalurl() {
        return originalurl;
    }

    public void setOriginalurl(String originalurl) {
        this.originalurl = originalurl;
    }

    public long getUrlId() {
        return urlId;
    }

    public void setUrlId(long urlId) {
        this.urlId = urlId;
    }
}
