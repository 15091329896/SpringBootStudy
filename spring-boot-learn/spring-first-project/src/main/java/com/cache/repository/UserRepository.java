package com.cache.repository;

import com.cache.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String userName);
	List<User> findByUserNameAndAge(String userName, Integer age);
	List<User> findByUserNameLike(String userName);
}