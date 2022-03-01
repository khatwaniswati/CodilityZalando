import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PermMissingElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int[] arr = new int[l];
		for(int i=0; i<l; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		int result = solution(arr);
		System.out.println(result);
	}

	public static int solution(int[] A) {
		List<Integer> lst = Arrays.stream(A).sorted().boxed().collect(Collectors.toList());
		int no = 1;
		for(Integer i : lst) {
			if(i != no) {
				return no;
			}
			no++;
		}
		return no;
	}
	
}
