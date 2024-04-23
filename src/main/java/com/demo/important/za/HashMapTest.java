package com.demo.important.za;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shijianwei
 * @since 2019/03/31
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String keyStr = new String("hello world");
        String keyStr2 = String.valueOf(new Integer(1));
        //String keyStr2 = new String("hello world");
        System.out.println(keyStr.hashCode() == keyStr2.hashCode());
        System.out.println(keyStr.hashCode());
        System.out.println(keyStr2.hashCode());

        map.put(keyStr, 1);
        map.put(keyStr2, 2);

        System.out.println(map);
    }
}
