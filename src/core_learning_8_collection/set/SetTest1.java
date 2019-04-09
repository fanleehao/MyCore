package core_learning_8_collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/** 
 * @author :fanleehao
 * @email  :fanleehao@gmail.com
 * @time   :2019年1月6日 下午3:38:04 
 */
public class SetTest1 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
//		for (String string : set) {
//			System.out.println(string);
//		}
		
		Set<String> set2 = new LinkedHashSet<>();
		set2.add("hhhhh");
		set2.add("ooooo");
		set2.add("ppppp");
//		for (String string : set2) {
//			System.out.println(string);
//		}
		
		
		
		Set<String> tSet = new TreeSet<>();
		tSet.add("你好");
		tSet.add("我");
		tSet.add("好");
		for (String string : tSet) {
			System.out.println(string);
		}
	}
}
