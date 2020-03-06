package com.demo.important.algorithm;

/**
 * @author shijianwei
 * @since 2017/12/20
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arrays = {2, 5, 1, 7, 8, 9, 10, 3, 4};
		sort(arrays);
		for (int temp : arrays) {
			System.out.println(temp);
		}
	}

	public static void sort(final int[] arrays) {
		if (arrays == null || arrays.length < 2) {
			return;
		}

		int count = 0;

		for (int i = 0; i < arrays.length - 1; i++) {
			boolean breakFlag = true;
			for (int j = 0; j < arrays.length - i - 1; j++) {
				count++;
				if (arrays[j] > arrays[j + 1]) {
					int temp = arrays[j];
					arrays[j] = arrays[j + 1];
					arrays[j + 1] = temp;
					breakFlag = false;
				}
			}
			if(breakFlag) {
				break;
			}
		}

		System.out.println("count:" + count);
	}
}
