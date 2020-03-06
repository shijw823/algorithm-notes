package com.demo.important.lru;

import java.util.*;

/**
 * LruTest
 *
 * @author shijianwei
 * @since 2017/11/20
 */
public class LruTest<K, V> {
	public LinkedList<K> list = new LinkedList<>();

	public Map<K, V> map = new HashMap<>();

	private final int limit;

	public LruTest(int limit) {
		this.limit = limit;
	}


	public void put(K k, V v) {
		if(list.size() >= limit) {
			K k1 = list.removeFirst();
			map.remove(k1);
		}
		list.addLast(k);
		map.put(k, v);
	}

	public V get(K k) {
		list.remove(k);
		list.addLast(k);
		return map.get(k);
	}

	public static void main(String[] args) {
		LruTest<String, String> lruTest = new LruTest<>(3);
		lruTest.put("a", "1");
		lruTest.put("b", "2");
		lruTest.put("c", "3");
		System.out.println(lruTest.list + ":" + lruTest.map);
		lruTest.put("d", "4");
		System.out.println(lruTest.list + ":" + lruTest.map);
		lruTest.get("b");
		lruTest.put("e", "5");
		System.out.println(lruTest.list + ":" + lruTest.map);
	}

}
