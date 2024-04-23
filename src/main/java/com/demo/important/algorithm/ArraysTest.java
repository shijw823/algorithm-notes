package com.demo.important.algorithm;

/**
 * @author shijianwei
 * @since 2017/12/19
 */
public class ArraysTest {
	public static void main(String[] args) {
		int[] arrays = {1, 2, 3, 4, 5};
		reverseArray(arrays);
		for (int temp : arrays) {
			System.out.println(temp);
		}
	}

	private static void reverseArray(final int[] arrays) {
		if (arrays == null || arrays.length < 2) {
			return;
		}
		int len = arrays.length;
		int midIndex = len / 2;
		System.out.println("midIndex:" + midIndex);
		for (int i = 0; i < midIndex; i++) {
			int temp = arrays[i];
			arrays[i] = arrays[len - i - 1];
			arrays[len - i - 1] = temp;
		}
	}
}
