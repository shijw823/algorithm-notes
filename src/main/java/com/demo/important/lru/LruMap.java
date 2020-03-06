package com.demo.important.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LruMap
 *
 * @author jianweishi3@creditease.cn
 * @since 2019/02/19
 */
public class LruMap<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LruMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > capacity;
    }

    public static void main(String[] args) {
        LruMap lruMap = new LruMap(3);
        lruMap.put("a", 1);
        lruMap.put("b", 2);
        lruMap.put("c", 3);
        System.out.println(lruMap.get("b"));
        lruMap.put("d", 4);
        lruMap.put("e", 5);
        System.out.println(lruMap);
    }
}
