package zalando;

public class ObstacleBackTracking {

	static int startX;
	static int startY;
	public static void main(String[] args) {
		//String[] s = { "X.....>", "..v..X.", ".>.....", "A......" };
		String[] s = { "...XX", "AX..X", ".XX.."};
		int n=s.length;
		int m=s[0].length();
		boolean res = solution(s,n,m);
		System.out.println(res);
	}

	private static int[][] prepareBlockerGrid(String[] s, int n, int m) {
		int[][] blockerGrid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(s[i].charAt(j)=='X') {
					blockerGrid[i][j]=1;
				}else if(s[i].charAt(j)=='^') {
					for (int j2 = i; j2 >=0; j2--) {
						blockerGrid[j2][j]=1;
					}
				}else if(s[i].charAt(j)=='>') {
					for (int j2 = j; j2 <m; j2++) {
						blockerGrid[i][j2]=1;
					}
				}else if(s[i].charAt(j)=='v') {
					for (int j2 = i; j2 <n; j2++) {
						blockerGrid[j2][j]=1;
					}
				}else if(s[i].charAt(j)=='<') {
					for (int j2 = j; j2 >=0; j2--) {
						blockerGrid[i][j2]=1;
					}
				}else if(s[i].charAt(j)=='A') {
					startX=i;
					startY=j;
				}
			}
		}
		return blockerGrid;
	}

	private static boolean solution(String[] s, int n, int m) {
		int[][] blockerGrid=prepareBlockerGrid(s,n,m);
		System.out.println("BlockerGrid:");
		printSolution(blockerGrid);
		
		int sol[][] = new int[n][m];

		if (solveMazeUtil(blockerGrid, startX, startY, sol,n,m) == false) {
			System.out.println("Solution doesn't exist");
			return false;
		}
		System.out.println("Solution Grid");
		printSolution(sol);
		return true;
	}

	static boolean solveMazeUtil(int blockerGrid[][], int x, int y, int sol[][],int n, int m) {
		if (x == n - 1 && y == m - 1 && blockerGrid[x][y] == 0) {
			sol[x][y] = 1;
			return true;
		}

		if (isSafe(blockerGrid, x, y,n,m)) {
			if (sol[x][y] == 1)
				return false;
			sol[x][y] = 1;
			if (solveMazeUtil(blockerGrid, x + 1, y, sol,n,m))
				return true;
			if (solveMazeUtil(blockerGrid, x - 1, y, sol,n,m))
				return true;
			if (solveMazeUtil(blockerGrid, x, y + 1, sol,n,m))
				return true;
			if (solveMazeUtil(blockerGrid, x, y - 1, sol,n,m))
				return true;
			sol[x][y] = 0;
		}

		return false;
	}

	static void printSolution(int sol[][]) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[i].length; j++)
				System.out.print(" " + sol[i][j] + " ");
			System.out.println();
		}
	}

	static boolean isSafe(int blockerGRid[][], int x, int y , int n, int m) {
		return x >= 0 && x < n && y >= 0 && y < m && blockerGRid[x][y] == 0;
	}

}
