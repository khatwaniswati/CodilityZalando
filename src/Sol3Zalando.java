class Solution3Zalando {
	public static void main(String[] args) {

		int[] A = { 2,-2,-3,3 };
		int[] B = { 0,0,4,-4 };
		System.out.println(solution(A,B));
		//System.out.println(sumOfRemainingElements(A, 1));
	}
	public static int solution(int[] A, int[] B) {
		if(A.length == B.length) {
			for(int i=0; i<A.length; i++) {
				int aPlus = sumOfKElements(A, i);
				int bPlus = sumOfKElements(B, i);
				if(aPlus == bPlus) {
					int aRemainingPlus = sumOfRemainingElements(A, i+1);
					int bRemainingPlus = sumOfRemainingElements(B, i+1);
					if(aRemainingPlus == bRemainingPlus && aRemainingPlus == aPlus) {
						System.out.println(i);
						return i+1;
					}
				}
			}
		}
		return 0;
	}
	
	public static int sumOfKElements(int[] arr, int k) {
		int sum = 0;
		for(int i=0; i<=k; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	public static int sumOfRemainingElements(int[] arr, int k) {
		int sum = 0;
		for(int i=k; i<arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
}