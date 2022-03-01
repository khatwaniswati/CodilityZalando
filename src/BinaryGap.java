import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BinaryGap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int power = findPowerToTwo(n);
		System.out.println("result:" + power);

		int multiple = twoToThePower(power);
		int remaining = n - multiple;
		System.out.println("multiple:-" + multiple);
		System.out.println("remaining:-" + remaining);

		int[] arr = new int[power + 1];
		int[] resultArr = new int[power + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = twoToThePower(i);
		}
		resultArr[power] = 1;

		while (remaining >= 1) {
			int power1 = findPowerToTwo(remaining);
			System.out.println("power1:-" + power1);
			resultArr[power1] = 1;
			int multiple1 = twoToThePower(power1);
			remaining = remaining - multiple1;
			System.out.println("multiple1:-" + multiple1);
			System.out.println("remaining1:-" + remaining);
		}

		Stack<Integer> stack = null;
		List<Integer> zeroCount = new ArrayList<Integer>();
		for (int i = 0; i < resultArr.length; i++) {
			System.out.println(i + " " + resultArr[i]);
			if (resultArr[i] == 1) {
				if (stack == null) {
					stack = new Stack<Integer>();
				} else {
					if (stack.size() > 0) {
						zeroCount.add(stack.size());
						stack = new Stack<Integer>();
					}
				}
			}
			if (resultArr[i] == 0) {
				if (stack != null) {
					stack.push(0);
				}
			}
		}
		if (!zeroCount.isEmpty()) {
			Collections.sort(zeroCount);
			System.out.println("max binary gap:-" + zeroCount.get(zeroCount.size() - 1));
		} else {
			System.out.println("no gap");
		}
	}

	private static int twoToThePower(int n) {
		int result = 1;
		if (n == 0) {
			return 1;
		}
		while (n >= 1) {
			result = 2 * result;
			n--;
		}
		return result;
	}

	private static int findPowerToTwo(int n) {
		int cnt = 0;
		while (n > 1) {
			n = n / 2;
			cnt++;
		}
		return cnt;
	}
}
