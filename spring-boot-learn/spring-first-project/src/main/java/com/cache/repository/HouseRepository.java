package com.cache.repository;

import com.cache.bean.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House,Integer> {

    List<House> findHouseByHouseName(String name);
    House findHouseById(Integer id);


}