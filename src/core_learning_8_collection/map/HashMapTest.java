package core_learning_8_collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018年11月15日 上午8:52:21 
 */
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
//		Iterable<String> iterable = map.
		
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put(1, "hello");
		map.put("1", "a");
		map.put("2", "a");
//		for (String string : map.values()) {
//			System.out.println(string);
//		}
		Map<String, String> map2 = new Hashtable<>();
		map.put(null, "yyyyy");
		map.put(null, "aaaa");
		System.out.println(map.get(null));
	}
}
