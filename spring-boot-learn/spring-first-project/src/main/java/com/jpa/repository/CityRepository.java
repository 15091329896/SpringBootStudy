package com.jpa.repository;

import com.jpa.bean.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {

    //    新增
    @Override
    City save(City city);


    //    新增多条
    @Override
    <S extends City> List<S> saveAll(Iterable<S> entities);

    //  删除
    @Override
    void deleteById(Integer integer);

//删除成功确认是否还存在
    @Override
    boolean existsById(Integer integer);

    //  修改
//    同新增单条

    //    查询全部
    @Override
    List<City> findAll();

    //    查询单个
    @Override
    Optional<City> findById(Integer integer);
}