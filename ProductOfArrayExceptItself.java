/*
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptItself {
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		left[0] = 1;
		right[nums.length - 1] = 1;

		for (int i = 0; i < nums.length - 1; i++) {
			left[i + 1] = nums[i] * left[i];
		}

		for (int i = nums.length - 1; i > 0; i--) {
			right[i - 1] = right[i] * right[i];
		}

		for (int i = 0; i < nums.length; i++) {
			result[i] = left[i] * right[i];
		}

		return result;
	}

	public void printArray(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	}
}
