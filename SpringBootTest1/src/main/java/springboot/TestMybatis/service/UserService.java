package springboot.TestMybatis.service;

import java.util.List;

import springboot.TestJDBC.bean.User;

public interface UserService {

	public List<User> getAllUser();
}