
/*
 *https://leetcode.com/problems/group-anagrams/description/
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<ArrayList<Integer>, List<String>> map = new HashMap<>();
		for (String str : strs) {
			ArrayList<Integer> x = generate(str);
			if (map.get(x) == null) {
				map.put(x, new ArrayList<>());
			}
			List<String> list = map.get(x);
			list.add(str);
			map.put(x, list);
		}
		for (ArrayList<Integer> x : map.keySet()) {
			result.add(map.get(x));
		}
		return result;
	}

	public ArrayList<Integer> generate(String str) {
		ArrayList<Integer> x = new ArrayList<>(128);
		for (int i = 0; i < 128; i++) {
			x.add(0);
		}
		for (char car : str.toCharArray()) {
			x.set(car, x.get(car) + 1);
		}
		return x;
	}
}
