package com.demo.important.za;

/**
 * *********************ok
 * 何海涛面试100题 第55题
	 5的二进制是101，17的二进制10001。还是试着把计算分成三步：第一步各位相加但不计进位，
	 得到的结果是10100（最后一位两个数都是1，相加的结果是二进制的10。这一步不计进位，因此结果仍
	 然是0）；第二步记下进位。在这个例子中只在最后一位相加时产生一个进位，结果是二进制的10；第三
	 步把前两步的结果相加，得到的结果是10110，正好是22。由此可见三步走的策略对二进制也是管用的。

	 接下来我们试着把二进制上的加法用位运算来替代。第一步不考虑进位，对每一位相加。0加0与 1
	 加1的结果都0，0加1与1加0的结果都是1。我们可以注意到，这和异或的结果是一样的。对异或而言，0
	 和0、1和1异或的结果是0，而0和1、1和0的异或结果是1。接着考虑第二步进位，对0加0、0加1、1加0
	 而言，都不会产生进位，只有1加1时，会向前产生一个进位。此时我们可以想象成是两个数先做位与运
	 算，然后再向左移动一位。只有两个数都是1的时候，位与得到的结果是1，其余都是0。第三步把前两个
	 步骤的结果相加。如果我们定义一个函数AddWithoutArithmetic，第三步就相当于输入前两步骤的结果
	 来递归调用自己。
 */
public class AddTest {
	public static void main(String[] args) {
		int result = addWithoutArithmetic(34, 17);
		System.out.println(result);
		result = add(34, 17);
		System.out.println(result);
	}

	private static int addWithoutArithmetic(int num1, int num2) {
        if(num2 == 0) {
			return num1;
		}
		int sum = num1 ^ num2;
		int carry = (num1 & num2) << 1;
		return addWithoutArithmetic(sum, carry);
	}

	public static int add(int a, int b) {
		while (a != 0) {
			// 10000 00101
			int temp = a ^ b; //不带进位和
			a = (a & b) << 1; //进位
			b = temp;
		}
		return b;
	}
}
