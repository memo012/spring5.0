package com.adminsys.soundcode.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/1/14 下午5:01
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    // BeanPostProcessor 后置处理器


    /**
     * 执行自定义方法之前执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("4. 执行init方法之前处理："+beanName);
        return bean;
    }

    /**
     * 执行自定义方法之后处理
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("6. 执行init方法之后处理："+beanName);
        return bean;
    }
}
