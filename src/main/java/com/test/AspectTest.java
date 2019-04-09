package com.test;

import com.service.PersonServer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @Title: AspectTest
 * @ProjectName pro_aspect
 * @Description: TODO
 * @date 2019/4/9 000919:37
 */
public class AspectTest {
    @Test
    public void inteceptorTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        PersonServer personServerBean = (PersonServer) applicationContext.getBean("personServerImpl");
        //通过new对象是不会触发aop的
        personServerBean.save("uname?",23);
    }
}
