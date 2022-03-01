import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class OddOccurencesInArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		int[] arr = new int[arrSize];
		for(int i=0; i<arrSize; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> pairedMap = new HashMap<Integer, Integer>();
		for(int i=0; i<arrSize; i++) {
			map.put(i, arr[i]);
		}
		
		for(int i=0; i<arrSize; i++) {
			if(map.containsKey(i)) {
				int val = map.get(i);
				//Collection<Integer> lst = new ArrayList<Integer>(map.values());
				//lst.remove(map.get(i));
				map.remove(i);
				
				System.out.println(val+" "+map);
				int removeKey = 0;
				for(Entry<Integer, Integer> entry : map.entrySet()) {
					if(entry.getValue() == val) {
						removeKey = entry.getKey();
						pairedMap.put(i, removeKey);
						break;
					}
				}
				if(map.containsKey(removeKey)) {
					map.remove(removeKey);
				}
				System.out.println("after:"+map);
			}
		}
		System.out.println(pairedMap);
		List<Integer> lst = new ArrayList<Integer>();
		lst.addAll(pairedMap.keySet());
		lst.addAll(pairedMap.values());
		int indexx = 0;
		while(indexx<arrSize) {
			if(!lst.contains(indexx)){
				System.out.println( arr[indexx]);
			}
			indexx++;
		}
	}

}
