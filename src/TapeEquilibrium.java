import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TapeEquilibrium {

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

	public static int solution(int[] A) {
		if(A.length >1) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int p=A.length-1; p>0; p--) {
				int val1 = 0;
				int val2 = 0;
				for(int i=0; i<p; i++) {
					val1+= A[i];
				}
				for(int i=p; i<A.length; i++) {
					val2+= A[i];
				}
				int value = 0;
				if(val1>=val2) {
					value = val1-val2;
				}else if(val2>val1) {
					value = val2-val1;
				}
				map.put(p, value);
			}
			List<Integer> lst = map.values().stream()
					.collect(Collectors.toList());
			Collections.sort(lst);
			int min = lst.get(0);
			return min;
		}else if(A.length == 1) {
			return A[0];
		}else {
			return 0;
		}
	}

}
