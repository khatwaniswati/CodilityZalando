package zalando;
import java.util.Stack;

class StringTransform {

	public static String solution(String S) {
		int i = 0;
		StringBuilder sb = new StringBuilder(S);
		while (!sb.toString().isEmpty() && i < sb.length()) {
			char ch1 = sb.charAt(i);
			if ((i + 1) < sb.length()) {
				char ch2 = sb.charAt(i + 1);
				if ((ch1 == 'A' && ch2 == 'B') || (ch1 == 'B' && ch2 == 'A') || (ch1 == 'C' && ch2 == 'D')
						|| (ch1 == 'D' && ch2 == 'C')) {
					sb = new StringBuilder(sb.substring(0, i) + sb.substring(i + 2));
					i = 0;
				} else {
					i++;
				}
			} else
				break;
		}
		return sb.toString();
	}

	public static String solution2(String S) {
		Stack<Character> stack = new Stack<>();
		for (int j = 0; j < S.length(); j++) {
			char ch = S.charAt(j);
			if (!stack.isEmpty() && ((ch == 'A' && stack.peek() == 'B') || (ch == 'B' && stack.peek() == 'A')
					|| (ch == 'C' && stack.peek() == 'D') || (ch == 'D' && stack.peek() == 'C'))) {
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		int i = stack.size();
		StringBuilder s = new StringBuilder(i);
		s.setLength(i);
		while (!stack.isEmpty()) {
			s.setCharAt(i - 1, stack.pop());
			i--;
		}
		return s.toString();
	}

	public static void main(String[] args) {
		System.out.println(":" + solution("CBACD"));
		System.out.println(":" + solution("CABABD"));
		System.out.println(":" + solution("ACBDACBD"));
		System.out.println("Sol 2:");

		System.out.println(":" + solution2("CBACD"));
		System.out.println(":" + solution2("CABABD"));

		System.out.println(":" + solution2("ACBDACBD"));
	}
}
