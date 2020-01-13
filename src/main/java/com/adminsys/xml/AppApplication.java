package com.adminsys.xml;

import com.adminsys.xml.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-01-12 09-19
 **/

public class AppApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserEntity userEntity = context.getBean("userEntity", UserEntity.class);
        System.out.println(userEntity.toString());
    }
}
