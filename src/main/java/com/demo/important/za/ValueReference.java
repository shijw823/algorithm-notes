package com.demo.important.za;

/**
 * @author shijianwei
 * @since 2017/12/25
 */
public class ValueReference {
	public static void main(String[] args) {
		String str = "a";
		m(str);
		System.out.println(str);
	}

	private static void m(String str) {
		str = "b";
	}
}
