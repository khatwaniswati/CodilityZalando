import java.util.ArrayList;
import java.util.List;

class Solution1Zalando {

	public static void main(String[] args) {
		/*
		 * int n = 99999; n++; while(1==1) { if(returnTotal(n)==45) { break; } n++; }
		 * System.out.println(n);
		 */
		System.out.println(solution(99999));
	}

	/*
	 * public static int returnTotal(int N) { int total = 0, r = 0; while (N > 0) {
	 * r = N % 10; N = N / 10; total += r; } return total; }
	 * 
	 * public static int returnNoOfDigits(int N) { int noOfDigits = 0; while (N > 0)
	 * { N = N / 10; noOfDigits++; } return noOfDigits; }
	 */
	public static int solution(int N) {
		int total = 0, r = 0;
		int noOfDigits = 0;
		int temp = N;
		List<Integer> lst = new ArrayList<Integer>();
		while (temp > 0) {
			r = temp % 10;
			lst.add(r);
			temp = temp / 10;
			total += r;
			noOfDigits++;
		}
		if (noOfDigits == 1) {
			return N;
		} else if (noOfDigits == 2) {
			return twoDigitLogic(lst.get(0),lst.get(1));
		} else if (noOfDigits == 3) {
			return threeDigitLogic(lst.get(0),lst.get(1),lst.get(2));
		} else if (noOfDigits == 4) {
			return fourDigitLogic(lst.get(0),lst.get(1),lst.get(2),lst.get(3));
		} else if (noOfDigits == 5) {
			return fiveDigitLogic(lst.get(0),lst.get(1),lst.get(2),lst.get(3),lst.get(4), total);
		} else {
			return -1;
		}
	}

	public static int twoDigitLogic(int lastDigit,int firstDigit) {
		if(firstDigit<9 && lastDigit !=0) {
			firstDigit++;
			lastDigit--;
			return firstDigit*10+lastDigit;
		}else if(firstDigit==9 && lastDigit !=0) {
			int temp = lastDigit;
			int secondDigit = temp-1;
			return 100+(secondDigit*10+9);
		} else if (lastDigit == 0) {
			if(firstDigit != 1) {
				return 100+(firstDigit-1);
			}else {
				return 100;
			}
		}
		return 0;
	}

	public static int threeDigitLogic(int last, int lastSecond, int lastThird) {
		int lastTwo = lastSecond * 10 + last;
		if (lastTwo > 0) {
			int result = twoDigitLogic(last,lastSecond);
			if(lastThird == 9) {
					return result*10+9;
			}else {
				return result = lastThird * 100 + result;
			}
			
		}else if (lastTwo == 0) {
			if(lastThird == 1) {
				return 1000;
			}else {
				return 1000+(lastThird-1);
			}
		}
		return 0;
	}

	public static int fourDigitLogic(int last, int lastSecond, int lastThird, int lastFourth) {
		int lastThree = lastThird*100+lastSecond*10+last;
		if (lastThree > 0) {
			int temp = threeDigitLogic(last,lastSecond,lastThird);
			if(temp == 1899 && lastFourth == 9) {
				return 18999;
			}
			return lastFourth*1000+temp;
		} else {
			if(lastFourth == 1) {
				return 10000;
			}else {
				return 10000+(lastFourth-1);
			}
		}
	}

	private static int fiveDigitLogic(int last, int lastSecond, int lastThird, int lastFourth,int lastFifthDigit, int total) {
		int lastFour = lastFourth*1000+lastThird*100+lastSecond*10+last;
		if (lastFour > 0) {
			int temp = fourDigitLogic(last,lastSecond,lastThird,lastFourth);
			if(temp == 18999 && lastFifthDigit == 9) {
				return 189999;
			}
			return lastFifthDigit*10000+temp;
		} else {
			if(lastFifthDigit == 1) {
				return 100000;
			}else {
				return 100000+(lastFifthDigit-1);
			}
		}
	}

}