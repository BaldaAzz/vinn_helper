package com.vinnhelper.VinNHelper.models;


import jakarta.persistence.*;

@Entity
@Table(name = "vinCheckHistory")
public class UserVinCheckHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vinNumber")
    private VinNumber vinNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VinNumber getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(VinNumber vinNumber) {
        this.vinNumber = vinNumber;
    }
}
