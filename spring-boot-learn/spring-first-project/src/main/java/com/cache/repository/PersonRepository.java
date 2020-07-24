package com.cache.repository;

import com.cache.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

//	命名规则： find关键字 By关键字  find后面必须是实体类的名称 By后面必须是参数名称，按照驼峰命名 数据表的字段的名称必须是下划线分隔
	List<Person> findPersonByName(String name);
	Person findPersonById(Integer id);
	List<Person> findPersonByAddress(String address);
}