package com.adminsys.soundcode;

import com.adminsys.soundcode.config.OwnConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/1/14 上午11:59
 **/
public class AnnotationCode {
    public static void main(String[] args) {
        // 基于注解方式实现的
        ApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(OwnConfig.class);
    }

    /**
     *  ApplicationContext继承BeanFactory实现扩展的功能
     */
}
