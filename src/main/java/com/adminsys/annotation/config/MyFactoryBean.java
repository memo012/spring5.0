package com.adminsys.annotation.config;

import com.adminsys.annotation.entity.FactoryBeanEntity;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-01-13 11-12
 **/

public class MyFactoryBean implements FactoryBean<FactoryBeanEntity> {
    public FactoryBeanEntity getObject() throws Exception {
        return new FactoryBeanEntity();
    }

    public Class<?> getObjectType() {
        return FactoryBeanEntity.class;
    }

    public boolean isSingleton() {
        // 默认的情况下就是为true true表示为单例  false 表示为多例
        return true;
    }
}
