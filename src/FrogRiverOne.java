import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FrogRiverOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = sc.nextInt();
		}
		int X = sc.nextInt();
		sc.close();

		int result = solution(X,arr);
		System.out.println(result);
	}

	public static int solution(int X, int[] A) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i= 1; i<=X; i++) {
			map.put(i,null );
		}
		for(int i=0; i<A.length; i++) {
			if(map.containsKey(A[i])) {
				if(map.get(A[i]) == null) {
					map.put(A[i],""+i);
				}else {
					Collection<String> coll = map.values();
					if(!coll.contains(null)) {
						break;
					}
				}
				if(X == A[i]) {
					Collection<String> coll = map.values();
					if(!coll.contains(null)) {
						List<String> lst = coll.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
						return Integer.parseInt(lst.get(0));
					}
				}
			}
		}
		if(map.values() != null && !map.values().isEmpty()) {
			Collection<String> coll = map.values();
			if(!coll.contains(null)) {
				List<String> lst = coll.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
				return Integer.parseInt(lst.get(0));
			}
		}
		return -1;
	}

}