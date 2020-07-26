package com.multiDataSource.config.template5.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int houseId;
    private String houseName;
    private String houseIntroduce;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseIntroduce() {
        return houseIntroduce;
    }

    public void setHouseIntroduce(String houseIntroduce) {
        this.houseIntroduce = houseIntroduce;
    }

    public House(String houseName, String houseIntroduce) {
        this.houseName = houseName;
        this.houseIntroduce = houseIntroduce;
    }
}