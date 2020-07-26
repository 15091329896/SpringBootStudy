package com.multiDataSource.config.template4.repository;

import com.multiDataSource.config.template4.bean.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}