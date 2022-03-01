import java.util.Scanner;

public class FrogJmp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();
		sc.close();
		int result = solution(x, y, d);
		System.out.println(result);
	}

	public static int solution(int X, int Y, int D) {
		/*
		 * int sum = X+D; int cnt = 1; while(sum<Y) { sum+= D; cnt++; } return cnt;
		 */
		int total = Y-X;
		int cnt = total/D;
		int r = total%D;
		if(r>0) {
			cnt++;
		}
		return cnt;
	}
}
