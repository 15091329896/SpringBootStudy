package com.jpa.controller;

import com.jpa.bean.City;
import com.jpa.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    //http://localhost:8082/saveOne
    @GetMapping(value = "saveOne")
    public String saveOne(){
        City city = new City(1001, "大连", "山东老酒馆在大连的大连街");
        City save = cityRepository.save(city);
        return save.toString() + "添加成功";
    }

    //http://localhost:8082/saveMany
    @GetMapping(value = "saveMany")
    public String saveMany(){
//        City city1 = new City(1001, "大连", "山东老酒馆在大连的大连街");
        City city2 = new City(1002, "咸阳", "秦始皇在咸阳");
        City city3 = new City(1003, "西安", "大明宫在西安");
        List<City> cityList = new ArrayList<>();
        cityList.add(city2);
        cityList.add(city3);
        List<City> cities = cityRepository.saveAll(cityList);
        return cities.toString() + "添加成功";
    }

    //http://localhost:8082/deleteCity?cityId=2
    @GetMapping(value = "deleteCity")
    public String deleteCity(int cityId){
        cityRepository.deleteById(cityId);
        if (cityRepository.existsById(cityId)) {
            return "fail";
        }
        return "success";
    }

    //http://localhost:8082/updateCity
    @GetMapping(value = "updateCity")
    public String updateCity(){
        City city3 = new City(3, "西安", "李白西安");
        City save = cityRepository.save(city3);
        return city3.toString() + " --> " + save.toString();
    }

    //http://localhost:8082/getCityById?cityId=3
    @GetMapping(value = "getCityById")
    public City getCityById(int cityId){
        Optional<City> city = cityRepository.findById(cityId);
        return city.get();
    }

    //http://localhost:8082/getCityAll
    @GetMapping(value = "getCityAll")
    public List<City> getCityAll(){
        List<City> all = cityRepository.findAll();
        return all;
    }

}