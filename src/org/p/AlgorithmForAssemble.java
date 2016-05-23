package org.p;
public class AlgorithmForAssemble {

	/**
	 * �����µ�����
	 * 
	 * @param arr��ԭʼ���飩
	 * @param index�������ƶ��±꣩
	 */
	public static void newArray(String[] arr, int index) {
		// ����±�С��ԭʼ���鳤�����˳��ݹ�
		if (index < arr.length) {
			// ������ʾ��StringBuilder
			StringBuilder sb = new StringBuilder();
			// �����±�ָ��������Ԫ����Ϊ��ͷ��ĸ
			sb.append(arr[index]);
			// ����ԭʼ����
			for (int i = 0; i < arr.length; i++) {
				// �������Ԫ���뵱ǰString��ͷ��ĸ��һ��
				if (!arr[index].equals(arr[i])) {
					// String����������������
					sb.append(arr[i]);
				}
			}
			// ��Stringת��Ϊchar����
			char[] paramArr = sb.toString().toCharArray();
			// �����޸��꿪ͷ��ĸ��char����
			char[] oldArr = new char[paramArr.length];
			// ��ȫ����
			for (int i = 0; i < oldArr.length; i++) {
				oldArr[i] = paramArr[i];
			}
			// ִ������������㷨
			sortArr(sb.toString().toCharArray(), arr.length - 1, oldArr, 0);
			// ��ԭʼ����ݹ�������
			newArray(arr, ++index);
		}
	}

	/**
	 * ����������㷨
	 * 
	 * @param arr��������ͷ��ĸ��ԭʼ���飩
	 * @param index��������������Ԫ���±꣩
	 * @param oldArr���ݹ��������һ��������ԭʼ���飩
	 * @param sum���ݹ������һ���������ݹ��������
	 */
	public static void sortArr(char[] arr, int index, char[] oldArr, int sum) {
		// �ݹ��
		// �ж�����Ѿ�����һ���ֻأ���abcd -> abcd һ���ֻأ�������������һ��������ѭ�������������������Ƚ�
		// ��Ϊ��ʼ��ʱ����������һ��һ����������ӵڶ����ݹ��������ݹ����������֤���Ѿ������˵ݹ�����Ժ�
		if (isSame(arr, oldArr) && sum > 0) {
		} else {
			// �����������������±��Ѿ�Ϊ��������λ��Ҳ����2ʱ���ſ��Լ����ݹ�
			if (index > 1) {
				// ������Ԫ����֮ǰһ��Ԫ�ؽ��л���
				char targetChar = arr[index - 1];
				arr[index - 1] = arr[index];
				arr[index] = targetChar;
				// ����������ʾ�����StringBuilder
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i]);
				}
				// ��ʾ���
				System.out.println(sb.toString());
				// �ݹ������+1
				sum = sum + 1;
				// �ݹ�������У��������Ѿ�����Ԫ�ص����飬�±�ǰ�ƣ��ݹ��������һ���ݹ������������
				sortArr(arr, --index, oldArr, sum);
			} else {
				// ������������������±��Ѿ�Ϊ�����ڶ�λ��Ҳ����С�ڻ����1ʱ�����µݹ飬������������Ԫ���±�����
				sortArr(arr, arr.length - 1, oldArr, sum);
			}
		}
	}

	/**
	 * �ж�����char�����Ƿ����
	 * 
	 * @param arr������һ��
	 * @param arr1���������
	 * @return
	 */
	public static boolean isSame(char[] arr, char[] arr1) {
		// ��ʼ�����
		boolean result = true;
		// ����һ����ѭ��
		for (int i = 0; i < arr.length; i++) {
			// ��������в���ȵ�
			if (arr[i] != arr1[i]) {
				// ��ʼ���������Ϊfalse
				result = false;
			}
		}
		// ���ؽ��
		return result;
	}

	public static void main(String[] args) {
		// ����
		String[] array = { "a", "b", "c", "d" };
		newArray(array, 0);
	}

}