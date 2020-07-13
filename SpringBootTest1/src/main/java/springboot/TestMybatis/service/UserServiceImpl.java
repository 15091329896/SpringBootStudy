package springboot.TestMybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.TestJDBC.bean.User;
import springboot.TestMybatis.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}
    
}