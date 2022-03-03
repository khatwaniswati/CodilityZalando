package hackerrank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinSubArrayWithKDistinct {
	public static void main(String[] args) {
		System.out.println(findMinLenStr("ababcb", 3));
		System.out.println(findMinLenStr("efecfefd", 4));
		System.out.println(".."+findMinLenStr("ababab", 4)+"..");
		System.out.println(findMinLen(new ArrayList<>(Arrays.asList(3,2,3,3,1,3,3)), 3));
		System.out.println(findMinLen(new ArrayList<>(Arrays.asList(2,3,3,1,3,3)), 3));
		System.out.println(findMinLen(new ArrayList<>(Arrays.asList(1,2,2,1,2)), 4));
	}
	
	public static String findMinLenStr(String str, int k) {
		int start=0,end=0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(str.charAt(i),map.getOrDefault(str.charAt(i), 0)+1);
		}
		if(map.size()==k) {
			return str.substring(0, k);
		}else {
			for (int i = k; i < str.length(); i++) {
				map.put(str.charAt(i),map.getOrDefault(str.charAt(i), 0)+1);
				if(map.size()==k) {
					end=i;
					break;
				}
			}
		}
		for (int i = start; i <= end; i++) {
			if(map.get(str.charAt(i))==1) {
				start=i;
				break;
			}else {
				map.put(str.charAt(i), map.get(str.charAt(i))-1);
				start++;
			}
		}
		return str.substring(start, end+1);
	}
	public static int findMinLen(List<Integer> arr, int k) {
		int start=0,end=0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(arr.get(i),map.getOrDefault(arr.get(i), 0)+1);
		}
		if(map.size()==k) {
			return k;
		}else {
			for (int i = k; i < arr.size(); i++) {
				map.put(arr.get(i),map.getOrDefault(arr.get(i), 0)+1);
				if(map.size()==k) {
					end=i;
					break;
				}
			}
		}
		if(start==end) {
			return -1;
		}
		for (int i = start; i <= end; i++) {
			if(map.get(arr.get(i))==1) {
				start=i;
				break;
			}else {
				map.put(arr.get(i), map.get(arr.get(i))-1);
				start++;
			}
		}
		return end-start+1;
	}
}