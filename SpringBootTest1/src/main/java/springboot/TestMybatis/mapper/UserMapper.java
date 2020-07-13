package springboot.TestMybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import springboot.TestJDBC.bean.User;

@Mapper
public interface UserMapper {
	List<User> getAllUser();
}