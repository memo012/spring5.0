package com.adminsys.soundcode.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/1/14 下午3:08
 **/

public class SchoolEntity implements BeanNameAware, BeanFactoryAware, InitializingBean {

    public SchoolEntity() {
        System.out.println("1. 对象的实例初始化");
    }

    public void setBeanName(String name) {
        System.out.println("2. 对象的name:" + name);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3. 对象beanFactory:" + beanFactory);
    }



    public void afterPropertiesSet() throws Exception {
        System.out.println("5. bean init方法执行");
    }










}
