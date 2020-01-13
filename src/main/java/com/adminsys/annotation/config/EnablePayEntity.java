package com.adminsys.annotation.config;

import com.adminsys.annotation.entity.PayEntity;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({PayEntity.class})
public @interface EnablePayEntity {
    // 只要启动的时候 加入该EnablePayEntity 就会将payEntity实体类注入到spring容器

    // Enable注解的话 底层 实际上在调用@Import(PayEntity.class)

}
