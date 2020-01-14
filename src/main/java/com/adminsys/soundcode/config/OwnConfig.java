package com.adminsys.soundcode.config;

import com.adminsys.soundcode.entity.SchoolEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/1/14 下午3:07
 **/
@Configuration
@ComponentScan("com.adminsys.soundcode")
//@Import(MyApplicationContext.class)
public class OwnConfig {


    /**
     *  initMethod  指定初始化方法执行
     *  destroyMethod  指定销毁方法
     * @return
     */
//    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Bean
    public SchoolEntity schoolEntity(){
        return new SchoolEntity();
    }

}
