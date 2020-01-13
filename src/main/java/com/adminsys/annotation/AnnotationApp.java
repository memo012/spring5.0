package com.adminsys.annotation;

import com.adminsys.annotation.config.MyConfig;
import com.adminsys.annotation.entity.UserEntity;
import com.adminsys.annotation.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-01-12 09-47
 **/

public class AnnotationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("配置文件启动...");
//        UserEntity userService = annotationConfigApplicationContext.getBean("com.adminsys.annotation.entity.UserEntity", UserEntity.class);
//        System.out.println(userService.toString());
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }

    /*
    springioc 容器中注入对象
    @Bean 往springioc 中注入bean对象 外部方式<br>
    @Import 往springioc 中注入bean对象 外部方式<br>
    @Service @Repository 注入对象更好区分应用场景底层都是使用@Component注解 注解加上@ComponentScan<br>
     */

}
