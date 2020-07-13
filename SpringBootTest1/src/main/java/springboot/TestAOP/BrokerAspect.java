package springboot.TestAOP;
 
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
 
/**
* @desc: 经纪人切面
* @author: CSH
**/
@Aspect
@Component
public class BrokerAspect {
 
    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
	@Pointcut("execution(* springboot.TestAOP.*.*(..))")
	public void pointCut() {}
 
    /**
    * @description  在连接点执行之前执行的通知
    */
    @Before("pointCut()")
    public void doBeforeGame(){
        System.out.println("前置通知");
    }
 
    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("pointCut()")
    public void doAfterGame(){
        System.out.println("后置通知");
    }
 
    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("pointCut()")
    public void doAfterReturningGame(){
        System.out.println("返回通知");
    }
 
    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("pointCut()")
    public void doAfterThrowingGame(){
        System.out.println("异常通知");
    }
}