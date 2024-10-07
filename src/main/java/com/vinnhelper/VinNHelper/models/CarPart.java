package com.vinnhelper.VinNHelper.models;

import jakarta.persistence.*;

@Entity
@Table(name = "carParts")
public class CarPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToMany
//    @JoinColumn(name = "vinNumber")
//    private VinNumber vinNumber;

    private String partName;
    private int originalPartNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public VinNumber getVinNumber() {
//        return vinNumber;
//    }
//
//    public void setVinNumber(VinNumber vinNumber) {
//        this.vinNumber = vinNumber;
//    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getOriginalPartNumber() {
        return originalPartNumber;
    }

    public void setOriginalPartNumber(int originalPartNumber) {
        this.originalPartNumber = originalPartNumber;
    }
}
