package com.adminsys.annotation.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-01-13 10-56
 **/

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.adminsys.annotation.entity.UsersEntity"};
    }
}
