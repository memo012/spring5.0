package com.adminsys.annotation.config;

import com.adminsys.annotation.entity.MsEntity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-01-13 10-59
 **/

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *   AnnotationMetadata 注解信息
     * @param importingClassMetadata
     * @param registry
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // spring 容器中 bean 的信息 Bean Definition 信息 手动注册到ioc容器中
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(MsEntity.class);
        registry.registerBeanDefinition("msEntity", rootBeanDefinition);
    }

    /*
    FactoryBean 往ioc容器中存入对象   BeanFactory 从ioc容器中获取对象
     */
}
