import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class OddOccurencesInArray2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		int result = solution(arr);
		System.out.println(result);
	}

	public static int solution(int[] arr) {
		int arrSize = arr.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arrSize; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		if (!map.isEmpty()) {
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() % 2 != 0) {
					return entry.getKey();
				}
			}

		}
		return 0;
	}

}