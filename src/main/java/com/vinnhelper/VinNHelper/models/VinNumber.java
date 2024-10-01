package com.vinnhelper.VinNHelper.models;

import jakarta.persistence.*;

@Entity
@Table(name = "vinNumbers")
public class VinNumber {

    @Id
    private String vinNumber;
    private Long carInfoId;

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public Long getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(Long carInfoId) {
        this.carInfoId = carInfoId;
    }
}
