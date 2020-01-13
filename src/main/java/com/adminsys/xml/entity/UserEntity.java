package com.adminsys.xml.entity;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-01-12 09-17
 **/

public class UserEntity {

    private String name;

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
