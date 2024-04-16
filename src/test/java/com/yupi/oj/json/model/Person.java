package com.yupi.oj.json.model;

import cn.hutool.db.handler.StringHandler;
import lombok.Data;

import java.util.List;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/24 19:15
 * @Package com.yupi.oj.json.model
 * @Version 1.0
 * @Since 1.0
 */
@Data
public class Person {

    private String name;
    private Integer age;
    private List<String> hobbies;

    public Person(String name, Integer age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }
}
