package com.demo.study.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @see com.demo.important.lru.LruTest
 */
public class LRUCache {
    private MyLinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new MyLinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }

    public MyLinkedHashMap<Integer, Integer> getCache() {
        return cache;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        int i = lruCache.get(1);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        MyLinkedHashMap<Integer, Integer> cache = lruCache.getCache();
        Set<Map.Entry<Integer, Integer>> entries = cache.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getValue());
        }
    }

    class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private int capacity;

        public MyLinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return this.size() > capacity;
        }
    }
}
