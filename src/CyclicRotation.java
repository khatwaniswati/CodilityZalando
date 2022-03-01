import java.util.Scanner;

public class CyclicRotation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();

		int[] result = rotateArray(arr, k);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static int[] rotateArray(int[] arr, int k) {
		int len = arr.length;
		if(len>1) {
			if(k>len) {
				k = k%len;
			}
			if (k > 0) {
					int[] newArr = arr.clone();
					for (int it = len - 1; it >= 0; it--) {
						int t = it-k;
						if(t<0) {
							int shift = len+t;
							arr[it] = newArr[shift];
						}else {
							arr[it] = newArr[it - k];
						}
					}
			}
		}
		return arr;
	}

}
