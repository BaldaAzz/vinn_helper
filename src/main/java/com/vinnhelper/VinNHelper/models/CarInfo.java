package com.vinnhelper.VinNHelper.models;


import jakarta.persistence.*;

@Entity
@Table(name = "carsInfo")
public class CarInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    Придумать, что можно добавить
    private String otherInformation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}
