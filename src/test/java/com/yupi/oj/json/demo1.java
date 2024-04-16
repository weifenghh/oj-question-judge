package com.yupi.oj.json;

import cn.hutool.core.lang.hash.Hash;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yupi.oj.json.model.Person;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/24 15:23
 * @Package com.yupi.oj.json
 * @Version 1.0
 * @Since 1.0
 */
public class demo1 {

    @Test
    public void test1(){
        JSONObject obj = JSONUtil.createObj();
        obj.put("name","jack");
        obj.put("age",20);
        obj.put("sex","男");
        obj.put("price",12.666);

        System.out.println("JSON对象=" + obj);
        System.out.println("JSON字符串=" + obj.toString());
        System.out.println("JSON对象=" + JSONUtil.parseObj(obj));

        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
        System.out.println(JSONUtil.parseObj(jsonStr));

        JSONObject jsonObject = new JSONObject(jsonStr);
        System.out.println(jsonObject.toString());

        String jsonArrayStr = "[\"value1\", \"value2\", \"value3\"]";
        JSONArray array = JSONUtil.parseArray(jsonArrayStr);
        System.out.println(array);
    }

    @Test
    public void gsonTest(){
        Person person = new Person("孬孬",20, Arrays.asList("自由", "迫害莱纳"));
        Gson gson = new Gson();
        System.out.println("对象《==》json字符串");
        String p = gson.toJson(person);
        System.out.println("对象转json字符串=" + p);
        Person p1 = gson.fromJson(p, Person.class);
        System.out.println("json字符长转对象=" + p1);

        System.out.println("List<==>json字符串");
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("孬孬",20, Arrays.asList("自由", "迫害莱纳")));
        personList.add(new Person("康康",20, Arrays.asList("自由", "迫害莱纳")));
        String personListStr = gson.toJson(personList);
        System.out.println("对象集合转json字符串=" + personListStr);
        List<Person> newPersonList = gson.fromJson(personListStr, List.class);
        System.out.println("json字符串转对象集合=" + newPersonList);
        List<Person> newPersonList1 = gson.fromJson(personListStr, new TypeToken<List<Person>>() {
        }.getType());
        System.out.println("json字符串转对象集合1=" + newPersonList1);

        System.out.println("Map<==>json字符串");
        HashMap<String, Person> personMap = new HashMap<>();
        Person person1 = new Person("孬孬", 20, Arrays.asList("自由", "迫害莱纳"));
        Person person2 = new Person("康康", 20, Arrays.asList("自由", "迫害莱纳"));
        personMap.put("person1",person1);
        personMap.put("person2",person2);
        String personMapStr = gson.toJson(personMap);
        System.out.println(personMapStr);
        HashMap<String,Person> personMap1 = gson.fromJson(personMapStr,new TypeToken<HashMap<String,Person>>(){}.getType());
        System.out.println(personMap1);
    }

    @Test
    public void fastJsonTest(){
        /**
         * JSON:toJsonString(对象->json字符串)、parseObject(json字符串->json对象)
         * TypeReference
         * jsonObject:getString  getJsonObject
         * jsonArray:
         */
    }

}
