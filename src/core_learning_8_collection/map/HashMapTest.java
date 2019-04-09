package core_learning_8_collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import sun.print.resources.serviceui;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2018Äê11ÔÂ15ÈÕ ÉÏÎç8:52:21 
 */
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
//		Iterable<String> iterable = map.
		
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put(1, "hello");
		map.put("1", "a");
		map.put("2", "a");
		map.put(null, "22");
		map.put(null, null);
		for (String string : map.values()) {
			System.out.println(string);
		}
//		Map<String, String> map2 = new Hashtable<>();
//		map2.put(null,null);
//		map.put(null, "aaaa");
//		System.out.println(map.get(null));
	}
	
	@Test
	public void test1(){
//		Object a = "hello";
//		System.out.println(a.hashCode());
//		int h = a.hashCode()>>>16;
//		System.out.println(h);
//		System.out.println(a.hashCode() ^ h);
//		System.out.println((a.hashCode() ^ h) & 15);
		
		Map<String, String> map = new Hashtable<>();
		map.put(null, "a");
		System.out.println(map.get(null));
		map.put(null, "ab");
		System.out.println(map.get(null));
		map.put(null, null);
		System.out.println(map.get(null));
	}
}
