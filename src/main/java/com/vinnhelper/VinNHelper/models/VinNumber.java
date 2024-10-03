package com.vinnhelper.VinNHelper.models;

import jakarta.persistence.*;

@Entity
@Table(name = "vinNumbers")
public class VinNumber {

    @Id
    private String vinNumber;

    @OneToOne
    @JoinColumn(name = "id")
    private CarInfo carInfo;

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfoId(CarInfo carInfo) {
        this.carInfo = carInfo;
    }
}
