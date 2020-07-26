package com.multiDataSource.controller;

import com.multiDataSource.config.template4.bean.City;
import com.multiDataSource.config.template4.repository.CityRepository;
import com.multiDataSource.config.template5.bean.House;
import com.multiDataSource.config.template5.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    HouseRepository houseRepository;
// http://localhost:8082/test
    @GetMapping("/test")
    public String template4(){
        City city = new City("北京","中国首都");
        cityRepository.save(city);
        House house = new House("老酒馆","特别老的老酒馆");
        houseRepository.save(house);
        return "success";
    }


}