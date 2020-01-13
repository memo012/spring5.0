package com.adminsys.annotation.config;

import com.adminsys.annotation.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-01-12 09-48
 **/
@ComponentScan("com.adminsys.annotation")
@Import({UserEntity.class, MyImportSelector.class,
        MyImportBeanDefinitionRegistrar.class})
@EnablePayEntity
public class MyConfig {

    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }

}
