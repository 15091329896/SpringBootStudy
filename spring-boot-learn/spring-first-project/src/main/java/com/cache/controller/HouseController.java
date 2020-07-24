package com.cache.controller;

import com.cache.bean.House;
import com.cache.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    //http://localhost:8080/house/saveHouse?id=1&houseName=别墅&houseSize=1220平方米
    @GetMapping("/saveHouse")
    @CachePut(value="house", key="#id")
    public House saveHouse(Integer id, String houseName, String houseSize) {
        House house=new House(1001, "大连街", "001");
        House house1=new House(1002, "大连街", "002");
        House house2=new House(1003, "大连街", "003");
        House house3=new House(1004, "大连街", "004");
        List<House> houses=new ArrayList<>();
        houses.add(house);
        houses.add(house1);
        houses.add(house2);
        houses.add(house3);
        houseRepository.saveAll(houses);
        return house;
    }

    //http://localhost:8080/house/queryHouse?id=1001
    @GetMapping("/queryHouse")
    @Cacheable(value="house", key="#id")
    public House findHouseById(Integer id) {
        House house=houseRepository.findHouseById(id);
        return house;
    }

    //http://localhost:8080/house/deleteHouse?id=1002
    @GetMapping("/deleteHouse")
    public String deleteById(Integer id) {
        houseRepository.deleteById(id);
        return "success";
    }

    //http://localhost:8080/house/deleteCache
    @GetMapping("/deleteCache")
    @CacheEvict(value="house", allEntries=true)
    public void findHouseByName() {
        List<House> houses=houseRepository.findHouseByHouseName("大连街");
    }

}