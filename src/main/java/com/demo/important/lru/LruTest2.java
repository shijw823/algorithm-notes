package com.demo.important.lru;

import java.util.*;

/**
 * LruTest2
 *
 * @author shijianwei
 * @since 2017/11/20
 */
public class LruTest2 {
	private static class LruCacheLinkedHahMap<K, V> extends LinkedHashMap<K, V> {
		private final int limit;

		public LruCacheLinkedHahMap(int initialCapacity, float loadFactor, boolean accessOrder) {
			super(initialCapacity, loadFactor, accessOrder);
			this.limit = initialCapacity;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
			return size() > this.limit;
		}
	}

	public static void main(String[] args) {
		LruCacheLinkedHahMap<String, String> cacheLinkedHahMap = new LruCacheLinkedHahMap<>(3, 0.75f, true);
		cacheLinkedHahMap.put("1", "1");
		cacheLinkedHahMap.put("2", "2");
		cacheLinkedHahMap.put("3", "3");
		System.out.println(cacheLinkedHahMap);
		cacheLinkedHahMap.put("4", "4");
		System.out.println(cacheLinkedHahMap);
		cacheLinkedHahMap.get("2");
		cacheLinkedHahMap.put("5", "5");
		System.out.println(cacheLinkedHahMap);
	}
}
