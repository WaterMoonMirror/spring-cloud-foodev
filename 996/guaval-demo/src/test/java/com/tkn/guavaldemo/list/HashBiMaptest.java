package com.tkn.guavaldemo.list;

import com.google.common.collect.HashBiMap;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/7/12 15:28
 * @description: 键值对的双向映射
 */
public class HashBiMaptest {
    public static void main(String[] args) {
        final HashBiMap<String, String> hashBiMap = HashBiMap.create();
        hashBiMap.put("name","a");
        hashBiMap.put("name","a");
        hashBiMap.put("name","b");
        hashBiMap.put("name","b");
        hashBiMap.put("name","c");
        hashBiMap.put("age","1");
        hashBiMap.put("age","1");
        hashBiMap.put("age","2");
        hashBiMap.put("age","3");
        // 多次添加相同的键，会替换原有的值
        System.out.println(hashBiMap.get("name"));
        // 反转使用值查询键
        System.out.println(hashBiMap.inverse().get("c"));
    }
}
