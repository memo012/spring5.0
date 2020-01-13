package com.adminsys.annotation.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-01-12 09-47
 **/
@Service
//@Lazy
public class UserService {

    /*
    @Lazy 如果为true 的情况下， 懒汉式  在获取的时候才被初始化
    @Lazy 如果为false 的情况下，饿汉式  在启动时加载
     */
    public UserService(){
        System.out.println("无参构造函数启动...");
    }

}
