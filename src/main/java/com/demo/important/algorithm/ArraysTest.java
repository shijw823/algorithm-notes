package com.demo.important.algorithm;

/**
 * @author shijianwei
 * @since 2017/12/19
 */
public class ArraysTest {
	public static void main(String[] args) {
		int[] arrays = {1, 2, 3, 4, 5, 6};
		reverseArray2(arrays);
		for (int temp : arrays) {
			System.out.println(temp);
		}
	}

	// 原地翻转数组（单指针法）
	private static void reverseArray(final int[] arrays) {
		if (arrays == null || arrays.length < 2) {
			return;
		}
		int len = arrays.length;
		for (int i = 0; i < len / 2; i++) {
			int temp = arrays[i];
			arrays[i] = arrays[len - i - 1];
			arrays[len - i - 1] = temp;
		}
	}

	public static void reverseArray2(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			// 交换左右指针的元素
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
	}
}
