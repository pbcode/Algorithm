package org.p;
public class AlgorithmForAssemble {

	/**
	 * 产生新的数组
	 * 
	 * @param arr（原始数组）
	 * @param index（数组移动下标）
	 */
	public static void newArray(String[] arr, int index) {
		// 如果下标小于原始数组长度则退出递归
		if (index < arr.length) {
			// 创建显示用StringBuilder
			StringBuilder sb = new StringBuilder();
			// 连接下标指定的数组元素作为开头字母
			sb.append(arr[index]);
			// 遍历原始数组
			for (int i = 0; i < arr.length; i++) {
				// 如果数组元素与当前String打头字母不一样
				if (!arr[index].equals(arr[i])) {
					// String连接数组其他部分
					sb.append(arr[i]);
				}
			}
			// 将String转化为char数组
			char[] paramArr = sb.toString().toCharArray();
			// 备份修改完开头字母的char数组
			char[] oldArr = new char[paramArr.length];
			// 完全备份
			for (int i = 0; i < oldArr.length; i++) {
				oldArr[i] = paramArr[i];
			}
			// 执行真正的组合算法
			sortArr(sb.toString().toCharArray(), arr.length - 1, oldArr, 0);
			// 用原始数组递归继续组合
			newArray(arr, ++index);
		}
	}

	/**
	 * 真正的组合算法
	 * 
	 * @param arr（更换完头字母的原始数组）
	 * @param index（待调换的数组元素下标）
	 * @param oldArr（递归基的其中一个条件，原始数组）
	 * @param sum（递归基的另一个条件，递归计数器）
	 */
	public static void sortArr(char[] arr, int index, char[] oldArr, int sum) {
		// 递归基
		// 判断组合已经走完一个轮回，即abcd -> abcd 一个轮回，两个条件，第一个条件是循环的数组与待操作数组比较
		// 因为初始化时，两个数组一定一样，所以添加第二个递归条件，递归计数器，保证在已经进行了递归操作以后
		if (isSame(arr, oldArr) && sum > 0) {
		} else {
			// 仅当待调换的数组下标已经为倒数第三位，也就是2时，才可以继续递归
			if (index > 1) {
				// 待调换元素与之前一个元素进行互换
				char targetChar = arr[index - 1];
				arr[index - 1] = arr[index];
				arr[index] = targetChar;
				// 创建用于显示结果的StringBuilder
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i]);
				}
				// 显示结果
				System.out.println(sb.toString());
				// 递归计数器+1
				sum = sum + 1;
				// 递归继续进行，参数（已经调换元素的数组，下标前移，递归基的条件一，递归基的条件二）
				sortArr(arr, --index, oldArr, sum);
			} else {
				// 如果当待调换的数组下标已经为倒数第二位，也就是小于或等于1时，重新递归，待调换的数组元素下标重置
				sortArr(arr, arr.length - 1, oldArr, sum);
			}
		}
	}

	/**
	 * 判断两个char数组是否相等
	 * 
	 * @param arr（数组一）
	 * @param arr1（数组二）
	 * @return
	 */
	public static boolean isSame(char[] arr, char[] arr1) {
		// 初始化结果
		boolean result = true;
		// 数组一进行循环
		for (int i = 0; i < arr.length; i++) {
			// 如果发现有不相等的
			if (arr[i] != arr1[i]) {
				// 初始化结果更改为false
				result = false;
			}
		}
		// 返回结果
		return result;
	}

	public static void main(String[] args) {
		// 测试
		String[] array = { "a", "b", "c", "d" };
		newArray(array, 0);
	}

}