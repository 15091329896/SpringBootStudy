package springboot.TestLog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/")
	@ResponseBody
	public String test() {
		System.out.println("springboot项目启动成功!");
		return "springboot项目启动成功!";
	}
}