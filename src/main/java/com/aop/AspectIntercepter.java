package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Administrator
 * @Title: AspectIntercepter
 * @ProjectName pro_aspect
 * @Description: TODO
 * @date 2019/4/9 000915:49
 */
@Aspect//声明这是一个切面
@Component//声明组件
public class AspectIntercepter {

    @Pointcut(value = "execution(* com.service.service_Impl.*(..))")
    private void pointCut(){//define a cutPoint 后面的通知直接引入切入点pointCut即可
    }

    //环绕通知（连接到切入点开始执行,下一步进入前置通知,在下一步才是执行操作方法）
    @Around(value = "pointCut()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("@around进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println(pjp.getThis()+"操作结束,退出方法;环绕[@Around]结束...");
        return object;
    }

    //前置通知(进入环绕后执行,下一步执行方法)
    public void doAccessCheck(JoinPoint jointPoint){
        System.out.println("@Before前置通知："+ Arrays.toString(jointPoint.getArgs()));
        //System.out.println("@AfterThrowing异常信息"+ex);
    }

    //异常通知(出错时执行)
    public void doAfterThrow(JoinPoint joinPoint,Throwable ex){
        System.out.println("@AfterThrowing例外通知(异常通知)"+Arrays.toString(joinPoint.getArgs()));
        System.out.println("@AfterThrowing 异常信息:"+ex);
    }

    //后置通知（返回之前通知）
    @After(value = "pointCut()")
    public void after(){
        System.out.println("@After后置通知");
    }

    //最后通知（正常返回通知,最后执行）
    @AfterReturning(value = "pointCut()")
    public void doAfter(){
        System.out.println("@AfterReturnning最终通知...End");
    }

}
