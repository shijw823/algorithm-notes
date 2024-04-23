package com.demo.important.algorithm;

import java.util.*;

/**
 * 删除list中指定的某一个值，两种删除的区别 原理
 *
 * @author shijianwei
 * @since 2017/12/19
 */
public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		//expectedModCount = modCount
		//ConcurrentModificationException

		//list add remove modCount++ 但是expectedModCount还是旧的值

		//private class Itr implements Iterator<E>    int expectedModCount = modCount;
		//iter.remove(); expectedModCount = modCount;
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			if("c".equals(iter.next())) {
				iter.remove();
			}
		}

		// ConcurrentModificationException
		//for(String str : list) {
		//	if("c".equals(str)) {
		//		list.remove(str);
		//	}
		//}

		for(String str : list) {
			System.out.println(str);
		}
	}
}
