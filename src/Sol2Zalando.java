
class Solution2Zalando {
	public static void main(String[] args) {

		int[] C = { 2,1,1,0,1 };
		System.out.println(solution(3, 2, C));


	}

	public static String solution(int U, int L, int[] C) {
		int len = C.length;
		int count1sRows = 0;
		int[][] arr = new int[2][len];
		for (int i = 0; i < len; i++) {
			if (C[i] == 2) {
				arr[0][i] = 1;
				arr[1][i] = 1;
				U--;
				L--;
			} else if (C[i] == 0) {
				arr[0][i] = 0;
				arr[1][i] = 0;
			} else {
				count1sRows++;
			}
		}
		StringBuilder result = new StringBuilder("");
		if (U + L != count1sRows) {
			return "IMPOSSIBLE";
		} else {
			for (int i = 0; i < len; i++) {
				if (C[i] == 1) {
					if (U > 0) {
						U--;
						arr[0][i] = 1;
						arr[1][i] = 0;
					} else if (L > 0) {
						arr[0][i] = 0;
						arr[1][i] = 1;
						L--;
					}
				}
			}
			result = new StringBuilder("");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < len; j++) {
					result.append(arr[i][j]);
				}
				result.append(",");
			}
			String res = result.substring(0,result.length()-1);
			return res;
		}

	}
}
