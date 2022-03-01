import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3};
		System.out.println(solution(arr1));
		int[] arr2 = {1,2,3};
		System.out.println(solution(arr2));
	}

	public static int solution(int[] A) {
		if(A.length>0) {
			Set<Integer> lst = Arrays.stream(A).boxed().collect(Collectors.toSet());
			for(int i=1; i<=A.length; i++) {
				if(!lst.contains(i)) {
					return i;
				}
			}
			return A.length+1;
		}
		return 1;
	}
}