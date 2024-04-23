package com.demo.important.za;

/**
 * 何海涛面试100题 第31题
 * @author shijianwei
 * @create 2017-09-14
 */
public class ReverseStr {
	public static void main(String[] args) {
		String str = "abcdefg";
		reverse(str);
	}

	private static void reverse(String str) {
		char[] chars = str.toCharArray();
		int len = chars.length / 2;
		for (int i = 0; i < len; i++) {
			char temp = chars[i];
			chars[i] = chars[str.length() - i -1];
			chars[str.length() - i -1] = temp;
		}
		System.out.println(chars);
	}


	//private static void reverse2(String str) {
	//	char[] chars = str.toCharArray();
	//	for(int i=0;i<chars.length;i++) {
	//		if(i == chars.length-1) {
	//			System.out.print(chars[i]);
	//		} else {
	//			reverse2(str.substring(i+1));
	//			System.out.print(chars[i]);
	//			break;
	//		}
	//	}
	//}
}
