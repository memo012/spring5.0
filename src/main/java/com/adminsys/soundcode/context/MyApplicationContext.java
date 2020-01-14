package com.adminsys.soundcode.context;

import com.adminsys.soundcode.entity.MemberEntity;
import com.adminsys.soundcode.entity.SchoolEntity;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/1/14 下午3:50
 **/
//@Component
//public class MyApplicationContext implements ApplicationContextAware {
//    private ApplicationContext applicationContext;
//
//    /**
//     *  spring底层为什么能够实现 ApplicationContextAware 接口  就能够拿到 ApplicationContext
//     * @param applicationContext
//     * @throws BeansException
//     */
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        SchoolEntity memberEntity = applicationContext.getBean("schoolEntity", SchoolEntity.class);
//        System.out.println("MemberEntity"+memberEntity);
//    }
//}
