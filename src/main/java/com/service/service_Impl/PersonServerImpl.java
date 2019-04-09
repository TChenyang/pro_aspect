package com.service.service_Impl;

import com.service.PersonServer;

/**
 * @author Administrator
 * @Title: PersonServerImpl
 * @ProjectName pro_aspect
 * @Description: TODO
 * @date 2019/4/9 000915:46
 */
public class PersonServerImpl implements PersonServer {
    @Override
    public void save(String uname, int age) {
        int a = 0;
        age = age/a;//打开上面两行报错,可触发异常通知
        System.out.print("com in personServerImpl save method..........");
    }
}
