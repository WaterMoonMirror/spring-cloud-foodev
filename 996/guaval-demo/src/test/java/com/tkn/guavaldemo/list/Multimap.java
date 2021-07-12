package com.tkn.guavaldemo.list;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ArrayListMultimap;
import com.google.gson.JsonNull;
import org.junit.jupiter.api.Test;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/12 14:56
 * @description: Multimap是把键映射到任意多个值的一般方式。
 */
public class Multimap {
    @Test
    public void test1(){
        //create  listMultimap
        final ArrayListMultimap<String, String> listMultimap = ArrayListMultimap.create();
        // create test data
        listMultimap.put("name","a");
        listMultimap.put("name","a");
        listMultimap.put("name","b");
        listMultimap.put("name","b");
        listMultimap.put("name","c");
        listMultimap.put("age","1");
        listMultimap.put("age","1");
        listMultimap.put("age","2");
        listMultimap.put("age","3");
        // get test data
        System.out.println("naem:");
        listMultimap.get("name").stream().forEach(v-> System.out.println(v));
        System.out.println("age:");
        listMultimap.get("age").stream().forEach(v-> System.out.println(v));
        System.out.println("keySet:");
        listMultimap.keySet().stream().forEach(v-> System.out.println(v));
        System.out.println("entries:");
        System.out.println(JSON.toJSONString(listMultimap.entries()));
        System.out.println("entrySet:");
        System.out.println(JSON.toJSONString(listMultimap.asMap().entrySet()));
    }
}
