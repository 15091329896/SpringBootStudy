
/*
      被移入到common中去了
 */
//package com.aop.anno;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
///*
//新建自定义注解，新建注解与新建接口类似，将interface改为@interface即可。
//        这个注解完成的事情是设计一个接口，这个接口可以接受参数
//        然后由Spring完成对这个注解的实现和参数解析处理
// */
//@Target({ElementType.METHOD, ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface DoneTime {
//    String param() default "";
//}
