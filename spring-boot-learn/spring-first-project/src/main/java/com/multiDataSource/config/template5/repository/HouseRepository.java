package com.multiDataSource.config.template5.repository;

import com.multiDataSource.config.template5.bean.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House,Integer> {
}